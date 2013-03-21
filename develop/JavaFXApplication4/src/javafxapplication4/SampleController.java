/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import es.ugr.decsai.jpons.uticalculator.Uti;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.chrono.GJChronology;

/**
 *
 * @author Jose Enrique Pons <jpons@decsai.ugr.es>
 */
public class SampleController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Slider startYear;
    @FXML
    private Slider endYear;
    @FXML
    private ScatterChart<Number, Number> sc;
    
    ScatterChart.Series<Number, Number> series;
    @FXML
    NumberAxis xAxis;
    @FXML
    NumberAxis yAxis;
    Uti queriedTime;
    
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        xAxis = new NumberAxis();
//        yAxis = new NumberAxis();
////        sc = new ScatterChart<Number,Number>(xAxis,yAxis);
        series = new ScatterChart.Series<>();
         Chronology chrono = GJChronology.getInstance();
        DateTime start = new DateTime(600,1,1,0,0,chrono);
        DateTime start1 = start.minusDays(100);
        DateTime start2 = start.plusDays(100);
        DateTime end = start.plusYears(10);
        DateTime end1 = end.minusDays(100);
        DateTime end2 = end.plusDays(100);
        queriedTime = new Uti(start1,start, start2, end1, end, end2);
        
         series.getData().add(new ScatterChart.Data<Number, Number>(queriedTime.getScreenX(), queriedTime.getScreenY()));
         sc.getData().add(series);
    }    

    @FXML
    private void startDragDone3(MouseEvent event) {
        createUti(startYear.getValue(), endYear.getValue());
    }

    @FXML
    private void onMouseEnd(MouseEvent event) {
        createUti(startYear.getValue(), endYear.getValue());
    }

   protected void createUti(double starts,double ends){
        Chronology chrono = GJChronology.getInstance();
        DateTime start = new DateTime(((Double) starts).intValue(),1,1,0,0,chrono);
        DateTime start1 = start.minusDays(100);
        DateTime start2 = start.plusDays(100);
        DateTime end =  new DateTime(((Double) ends).intValue(),1,1,0,0,chrono);
        DateTime end1 = end.minusDays(100);
        DateTime end2 = end.plusDays(100);
        queriedTime = new Uti(start1,start, start2, end1, end, end2);
        
        series.getData().clear();
        sc.getData().clear();
         series.getData().add(new ScatterChart.Data<Number, Number>(queriedTime.getScreenX(), queriedTime.getScreenY()));
         sc.getData().add(series);
   }

}
