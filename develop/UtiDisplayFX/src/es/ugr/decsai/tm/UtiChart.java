/*
 * Copyright (C) 2013 Jose Enrique Pons <jpons@decsai.ugr.es>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package es.ugr.decsai.tm;

import es.ugr.decsai.jpons.uticalculator.Uti;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.RadialGradientBuilder;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 * A class for visualization of utis in javafx
 *
 * @author Jose Enrique Pons <jpons@decsai.ugr.es>
 */
public class UtiChart {

    ScatterChart<Number, Number> chart;
    ScatterChart.Series<Number, Number> series;
    NumberAxis xAxis;
    NumberAxis yAxis;
    List<Uti> utiList;
    List<Ellipse> ellipseList;
    Uti queriedTime;

    public Uti getQueriedTime() {
        return queriedTime;
    }

    public void setQueriedTime(Uti queriedTime) {
        this.queriedTime = queriedTime;
        series.getData().add(new ScatterChart.Data<Number, Number>(queriedTime.getScreenX(), queriedTime.getScreenY()));
    }

    private void init() {
        xAxis = new NumberAxis();
        yAxis = new NumberAxis();
        chart = new ScatterChart<>(xAxis, yAxis);
        series = new ScatterChart.Series<>();
//        chart.getData().add(series);

    }

    public Point2D getScreenPos(double x, double y) {

        double screenX = xAxis.getDisplayPosition(x);
        double screenY = yAxis.getDisplayPosition(y);

        Point2D startPoint = xAxis.localToScene(0, 0);
        Point2D startPointY = yAxis.localToScene(0, 0);


        Point2D position = new Point2D(startPoint.getX() + screenX, screenY + startPointY.getY());

//        System.out.println("value x, y " + x + " , " + y);
//        System.out.println("value screnX " + screenX + " value screen y " + screenY);
//        System.out.println("Value start pointX " + startPoint);
//        System.out.println("Value start pointY " + startPointY);
//        System.out.println("DRAW POINT AT: " + position);

        return position;
    }

    protected void computeEllipses() {
        if (utiList == null) {
            return;
        }
        if (ellipseList == null) {
            ellipseList = new ArrayList<>(utiList.size());
        }
        for (Uti uti : utiList) {
//            Point2D screenPos = getScreenPos(uti.getScreenX(), uti.getScreenY());
//            //first approach when building the ellipse:
//            // consider de radius of the ellipse as the difference:
////            double radiusX = uti.getStart2() - uti.getStart1();
////            double radiusY = uti.getEnd2() - uti.getEnd1();
//
//            double radiusX = 15;
//            double radiusY = 15;
//            double posx = screenPos.getX();
//            double posy = screenPos.getY();
//
////            System.out.println("Pos x:"+posx+ " posy: "+posy);
//
//            Ellipse ellipse = new Ellipse(posx, posy, radiusX, radiusY);
//
//
//            RadialGradient radialGradient = RadialGradientBuilder.create()
//                    .focusAngle(0)
//                    .focusDistance(.1)
//                    .centerX(posx)
//                    .centerY(posy)
//                    .radius(Math.max(radiusX, radiusY))
//                    .proportional(false)
//                    .cycleMethod(CycleMethod.NO_CYCLE)
//                    .stops(new Stop(0, Color.BLACK), new Stop(1, Color.WHITESMOKE))
//                    .build();
//            ellipse.setFill(radialGradient);

            ellipseList.add(createEllipseFromUti(uti,true,Color.WHITESMOKE, Color.BLACK));
//            series.getData().add(new ScatterChart.Data<Number,Number>(u.getTx(),u.getTy()));
        }
        
        ellipseList.add(createEllipseFromUti(queriedTime, true, Color.WHITESMOKE, Color.RED));

        //

//        chart.getData().add(series);


    }

    protected Ellipse createEllipseFromUti(Uti uti, boolean gradient, Color colorMin, Color colorMax) {
        Point2D screenPos = getScreenPos(uti.getScreenX(), uti.getScreenY());
        //first approach when building the ellipse:
        // consider de radius of the ellipse as the difference:
//            double radiusX = uti.getStart2() - uti.getStart1();
//            double radiusY = uti.getEnd2() - uti.getEnd1();

        double radiusX = 15;
        double radiusY = 15;
        double posx = screenPos.getX();
        double posy = screenPos.getY();
        Ellipse ellipse = new Ellipse(posx, posy, radiusX, radiusY);

        if (gradient) {
            RadialGradient radialGradient = RadialGradientBuilder.create()
                    .focusAngle(0)
                    .focusDistance(.1)
                    .centerX(posx)
                    .centerY(posy)
                    .radius(Math.max(radiusX, radiusY))
                    .proportional(false)
                    .cycleMethod(CycleMethod.NO_CYCLE)
                    .stops(new Stop(0, colorMin), new Stop(1, colorMax))
                    .build();
            ellipse.setFill(radialGradient);
        }
        return ellipse;
    }

    public UtiChart() {
        init();
    }

    public ScatterChart<Number, Number> getChart() {
        return chart;
    }

    public XYChart.Series<Number, Number> getSeries() {
        return series;
    }

    public NumberAxis getxAxis() {
        return xAxis;
    }

    public NumberAxis getyAxis() {
        return yAxis;
    }

    public List<Uti> getUtiList() {
        return utiList;
    }

    public void setUtiList(List<Uti> utiList) {
        this.utiList = utiList;
        if (utiList != null) {
            for (Uti u : utiList) {
                series.getData().add(new ScatterChart.Data<Number, Number>(u.getScreenX(), u.getScreenY()));
            }
            chart.getData().add(series);
        }
    }

    public void start(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));
        root.getChildren().add(chart);
        primaryStage.show();

        //now compute the ellipses:
        computeEllipses();

        for (Ellipse e : ellipseList) {
            root.getChildren().add(e);
        }


    }
}
