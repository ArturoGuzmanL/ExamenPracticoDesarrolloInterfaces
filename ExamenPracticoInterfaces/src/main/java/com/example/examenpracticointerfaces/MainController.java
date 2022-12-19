package com.example.examenpracticointerfaces;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.IllegalFormatCodePointException;

public class MainController implements Initializable {


    @FXML
    private TextField textoTitulo;
    @FXML
    private TextField textoSubtitulo;
    @FXML
    private TableView tablaView;
    @FXML
    private TableColumn tablaNombre;
    @FXML
    private TableColumn tablaSexo;
    @FXML
    private TableColumn tablaEdad;
    @FXML
    private TableColumn tablaPeso;
    @FXML
    private TableColumn tablaAltura;
    @FXML
    private TableColumn tablaActi;
    @FXML
    private TableColumn tablaGER;
    @FXML
    private TableColumn tablaGET;
    @FXML
    private TextField rellenarNombre;
    @FXML
    private ChoiceBox rellenarSexo;
    @FXML
    private Spinner rellenarEdad;
    @FXML
    private Spinner rellenarPeso;
    @FXML
    private Spinner rellenarAltura;
    @FXML
    private ChoiceBox rellenarActividad;
    @FXML
    private Button addButton;
    @FXML
    private TextField textoBordeInferior;

    @FXML
    public void addButtonOnAction() {

        String nombre = null;
        String sexo = null;
        int edad = 0;
        int peso = 0;
        int altura = 0;
        String actividad = null;
        double GER = 0;
        double GET = 0;
        try {
            nombre = rellenarNombre.getText();
            sexo = rellenarSexo.getValue().toString();
            edad = (int) rellenarEdad.getValue();
            peso = (int) rellenarPeso.getValue();
            altura = (int) rellenarAltura.getValue();
            actividad = rellenarActividad.getValue().toString();

        if (sexo.equals("Mujer")) {
            GER = (655.0955 + (9.463 * peso) + (1.8496 * altura) - (4.6756 * edad));
        } else if (sexo.equals("Hombre")) {
            GER = (66.473 + (13.751 * peso) + (5.0033 * altura) - (6.755 * edad));
        }

        switch (actividad) {
            case "Muy ligera" -> GET = (GER * 1.3);
            case "Ligera" -> {
                if (sexo.equals("Mujer")) GET = (GER * 1.5);
                else GET = (GER * 1.6);
            }
            case "Moderada" -> {
                if (sexo.equals("Mujer")) GET = (GER * 1.6);
                else GET = (GER * 1.7);
            }
            case "Intensa" -> {
                if (sexo.equals("Mujer")) GET = (GER * 1.9);
                else GET = (GER * 2.1);
            }
        }

        } catch (NullPointerException e) {
            textoBordeInferior.setText("ERROR: Rellena todos los campos");
            textoBordeInferior.setStyle("-fx-text-fill: red; -fx-font-weight: bold");
        }

        tablaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tablaSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        tablaEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        tablaPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        tablaAltura.setCellValueFactory(new PropertyValueFactory<>("altura"));
        tablaActi.setCellValueFactory(new PropertyValueFactory<>("actividad"));
        tablaGER.setCellValueFactory(new PropertyValueFactory<>("GER"));
        tablaGET.setCellValueFactory(new PropertyValueFactory<>("GET"));

        Persona persona = new Persona(nombre, sexo, edad, peso, altura, actividad, GER, GET);

        if (persona!=null) {
            tablaView.getItems().add(persona);
            tablaView.refresh();

            rellenarNombre.clear();
            rellenarSexo.setValue(null);
            rellenarEdad.getValueFactory().setValue(0);
            rellenarPeso.getValueFactory().setValue(0);
            rellenarAltura.getValueFactory().setValue(0);
            rellenarActividad.setValue(null);
        }else {
            textoBordeInferior.setText("ERROR: No se ha podido añadir la persona");
            textoBordeInferior.setStyle("-fx-text-fill: red; -fx-font-weight: bold");
        }
    }

    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
        textoTitulo.setStyle("-fx-text-box-border: transparent; -fx-focus-color: transparent;");
        textoSubtitulo.setStyle("-fx-text-box-border: transparent; -fx-focus-color: transparent;");
        textoBordeInferior.setStyle("-fx-text-box-border: transparent; -fx-focus-color: transparent;");

        rellenarSexo.getItems().addAll("Mujer", "Hombre");
        rellenarActividad.getItems().addAll("Muy ligera", "Ligera", "Moderada", "Intensa");
        rellenarEdad.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0));
        rellenarPeso.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 400, 0));
        rellenarAltura.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 250, 0));
    }


}