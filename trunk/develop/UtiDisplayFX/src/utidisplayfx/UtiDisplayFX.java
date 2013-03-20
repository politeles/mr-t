/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utidisplayfx;

import es.ugr.decsai.historydb.HibernateUtil;
import es.ugr.decsai.historydb.dao.ContentDao;
import es.ugr.decsai.historydb.model.Contents;
import es.ugr.decsai.historydb.util.ContentsUtil;
import es.ugr.decsai.jpons.uticalculator.Uti;
import es.ugr.decsai.tm.UtiChart;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.chrono.GJChronology;

/**
 *
 * @author Jose
 */
public class UtiDisplayFX extends Application {

    private ScatterChart.Series<Number, Number> series;
    private double nextX = 0;
    private SequentialTransition animation;
    final NumberAxis xAxis = new NumberAxis(0, 10, 1);
    final NumberAxis yAxis = new NumberAxis(0, 10, 1);
    final ScatterChart<Number, Number> sc = new ScatterChart<Number, Number>(xAxis, yAxis);

    protected ScatterChart<Number, Number> createChart() {

        xAxis.setForceZeroInRange(false);


        // setup chart
        sc.setId("liveScatterChart");
        sc.setTitle("UTI visualizer");
        xAxis.setLabel("X Axis");
        xAxis.setAnimated(false);
        yAxis.setLabel("Y Axis");
        yAxis.setAutoRanging(false);


        // add starting data
        series = new ScatterChart.Series<Number, Number>();
        series.setName("Sine Wave");
        series.getData().add(new ScatterChart.Data<Number, Number>(5d, 5d));
        series.getData().add(new ScatterChart.Data<Number, Number>(0d, 0d));
        sc.getData().add(series);






        return sc;
    }

    @Override
    public void start(Stage primaryStage) {
        Session s = HibernateUtil.getSession();
        s.beginTransaction();

        ContentDao dao = new ContentDao(s);
        Chronology chrono = GJChronology.getInstance();
        DateTime start = new DateTime(620, 1, 1, 0, 0, chrono);
        DateTime end = new DateTime(710, 1, 1, 0, 0, chrono);

        DateTime start1 = new DateTime(610, 1, 1, 0, 0, chrono);
        DateTime start2 = new DateTime(630, 1, 1, 0, 0, chrono);

        DateTime end1 = new DateTime(700, 1, 1, 0, 0, chrono);
        DateTime end2 = new DateTime(720, 1, 1, 0, 0, chrono);


        List<Uti> utiList = new ArrayList<>();

        Uti queriedTime = new Uti(start1, start, start2, end1, end, end2);
        List<Contents> contentBetweenDates = dao.getContentBetweenDates(queriedTime);
        if (contentBetweenDates != null) {
            for (Contents c : contentBetweenDates) {
                //                DateTime startdt = new DateTime(c.getDatemillesimevaleur1(), (c.getDatemoisvaleur1()<1 || c.getDatemoisvaleur1()>12)?1:c.getDatemoisvaleur1(), (c.getDatejourvaleur1()<1 || c.getDatejourvaleur1()>30)?1:c.getDatejourvaleur1(), 0, 0, chrono);
                //                DateTime enddt = startdt.plusYears(30);
                //
                //
                //                DateTime start1dt = startdt.minusDays(100);
                //
                //
                //                DateTime start2dt = startdt.plusDays(100);
                //
                //
                //                DateTime enddt1 = enddt.minusDays(100);
                //
                //
                //                DateTime end2dt = enddt.plusDays(100);
                //
                //                Uti u = new Uti(start1dt, startdt, start2dt, enddt1, enddt, end2dt);
                Uti u = ContentsUtil.buildUtiFromContent(c);
                utiList.add(u);

            }
        }


//        List<Uti> utiList = new ArrayList<>();

//        for (int i = 0; i < 10; i++) {
//            int value = i * 10 + 5;
//            int value2 = value + (i * 2);
//            Uti u = new Uti(5 + value, 6 + value, 7 + value, 20 + value2, 21 + value2, 22 + value2);
//            utiList.add(u);
//        }

        UtiChart uc = new UtiChart();
        uc.setUtiList(utiList);
        uc.setQueriedTime(queriedTime);

        uc.start(primaryStage);


//        Group root = new Group();
//        primaryStage.setScene(new Scene(root));
//        root.getChildren().add(createChart());
//        primaryStage.show();
//        
//        double startx,endx,starty,endy;
//        
//        startx = xAxis.getZeroPosition();
//        endx = xAxis.getDisplayPosition(5d);
//        starty = yAxis.getZeroPosition();
//        endy = yAxis.getDisplayPosition(5d);
//        Point2D localToScene2 = xAxis.localToScene(0, 0);
//        Point2D localToScene1 = yAxis.localToScene(0,5);
//        Point2D localToScene3 = xAxis.localToScene(5,0);


//        System.out.println("local 2 scene: "+localToScene2);
////        System.out.println("local 2 scene: "+localToScene1);
//        
//        
//        
//      
//        System.out.println("startx "+startx+ " starty "+starty);
//        System.out.println("endx "+endx+ " endy "+endy);
//         //draw a line to the point:
//        Path p = new Path();
//        MoveTo m = new MoveTo(localToScene2.getX(), localToScene2.getY());
//        LineTo line = new LineTo(localToScene2.getX()+endx,  localToScene2.getY()-endy);
//
//        p.getElements().add(m);
//        p.getElements().add(line);
//        p.setStrokeWidth(5);
//        p.setStroke(Color.BLACK);
//        
//        Ellipse ellipse = new Ellipse(endx, endy, 10, 20);
//        
//        RadialGradient radialGradient =  RadialGradientBuilder.create()
//                .focusAngle(0)
//                .focusDistance(.1)
//                .centerX(endx)
//                .centerY(endy)
//                .radius(20)
//                .proportional(false)
//                .cycleMethod(CycleMethod.NO_CYCLE)
//                .stops(new Stop(0, Color.BLACK),new Stop(1,Color.WHITESMOKE))
//                .build();
//        ellipse.setFill(radialGradient);

//        for(Series<Number,Number> serie:sc.getData()){
//            System.out.println("Value: "+serie.getNode().localToScene(0, 0).getX());
//        }
//        for(Node node: root.getChildren()){
//            Bounds layoutBounds = node.getLayoutBounds();
//            System.out.println("Layout X: "+node.getLayoutX());
//            System.out.println("Layout Y: "+node.getLayoutY());
//            System.out.println("Translate X: "+node.getTranslateX());
//            System.out.println("Translate Y: "+node.getTranslateY());
//            //            node.get
//            ObservableList<Transform> transforms = node.getTransforms();
//            Transform localToParentTransform = node.getLocalToParentTransform();
//            double baselineOffset = node.getBaselineOffset();
//            Transform localToSceneTransform = node.getLocalToSceneTransform();
//            ReadOnlyObjectProperty<Bounds> boundsInLocalProperty = node.boundsInLocalProperty();
//            ReadOnlyObjectProperty<Bounds> boundsInParentProperty = node.boundsInParentProperty();
//            ObservableMap<Object, Object> properties = node.getProperties();
//            ObservableList<Transform> transforms1 = node.getParent().getTransforms();
//            
//        }
//        for(XYChart.Series<Number, Number> data :sc.getData()){
//            Bounds layoutBounds = data.getNode().getLayoutBounds();
//            
//            
//           
//        }
////        
//        root.getChildren().add(p);
//        root.getChildren().add(ellipse);


        //initialize(primaryStage);

    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
