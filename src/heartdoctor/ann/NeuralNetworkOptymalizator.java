/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package heartdoctor.ann;

import java.util.ArrayList;

/**
 *
 * @author Witek
 */
public class NeuralNetworkOptymalizator implements NeuralNetworkTrainingListener,
        Runnable{

    static private int INPUTS = 14,OUTPUTS = 1;

    private NeuralNetworkTrainer _nnTrainer;
    private NeuralNetwork _network;

    private int _minNumHiddenLayers = 1;
    private int _minNumNeuronsPerHiddenLayer = 1;
    private double[] _learningRateSet;
    private double[] _learningRateAdjustSet;
    private double[] _momentumSet;
    private double[] _forgettingRateSet;
 
    private int _maxNumHiddenLayers;
    private int _maxNumNeuronsPerHiddenLayer;

    public int optimumHiddenLayers;
    public int optimumNeuronsPerHiddenLayer;
    public double optimumLearningRate;
    public double optimumLearningRateAdjust;
    public double optimumMomentum;
    public double optimumForgettingRate;

    DataSet trainingSet;
    DataSet generalizationSet;
    DataSet validationSet;

    public NeuralNetworkOptymalizator(int nHL,int nNPH,double[] lR,double[] lRA,double[] m,double[] fR,DataSet data){
        _maxNumHiddenLayers = nHL;
        _maxNumNeuronsPerHiddenLayer = nNPH;

        
        int i=data.entries.size();

        // Wprowadzić loswo wybierane rekordy
        trainingSet.entries = (ArrayList<DataEntry>) data.entries.subList(0, (int)0.6*i);
        generalizationSet.entries = (ArrayList<DataEntry>) data.entries.subList((int)0.6*i+1, (int)0.8*i);
        validationSet.entries = (ArrayList<DataEntry>) data.entries.subList((int)0.8*i+1, i-1);
    }
    
    public NeuralNetworkOptymalizator(int minHL,int maxHL,int minNPH,int maxNPH,double[] LR,double[] LRA,double[] M,double[] FR,DataSet data){

        _minNumHiddenLayers = minHL;
        _minNumNeuronsPerHiddenLayer = minNPH;
        _learningRateSet = LR;
        _learningRateAdjustSet = LRA;
        _momentumSet = M;
        _forgettingRateSet = FR;
        
        _maxNumHiddenLayers = maxHL;
        _maxNumNeuronsPerHiddenLayer = maxNPH;

        int i=data.entries.size();
        // Wprowadzić loswo wybierane rekordy
        trainingSet.entries = (ArrayList<DataEntry>) data.entries.subList(0, (int)0.6*i);
        generalizationSet.entries = (ArrayList<DataEntry>) data.entries.subList((int)0.6*i+1, (int)0.8*i);
        validationSet.entries = (ArrayList<DataEntry>) data.entries.subList((int)0.8*i+1, i-1);
    }

    @Override
    public void run(){
        for(int h = _minNumHiddenLayers; h <= _maxNumHiddenLayers; h++)
            for(int p = _minNumNeuronsPerHiddenLayer; p <= _maxNumNeuronsPerHiddenLayer; p++)
                for(int lr = 0 ; lr < _learningRateSet.length; lr++)
                    for(int lra = 0; lra <= _learningRateAdjustSet.length; lra++)
                        for(int m = 0; m <= _momentumSet.length; m++)
                            for(int fr = 0; fr <= _forgettingRateSet.length ; fr++){
                        // DO SOMETHING AMAZING!!! -----------------------------
                                _network = new NeuralNetwork(INPUTS, OUTPUTS, h, p);
                                _nnTrainer = new NeuralNetworkTrainer(_network);
                                _nnTrainer.setLearningRate(lr);
                                _nnTrainer.setLearningRateAdjust(lra);
                                _nnTrainer.setMomentumConst(m);
                                _nnTrainer.setForgettingRate(fr);
                                _nnTrainer.addListener(this);
                                _nnTrainer.trainNetwork(trainingSet, generalizationSet, validationSet);
                            }
    }

    public void setGui(){

    }

    public void updateTrainingSetAccuracy(double accuracy) {
        throw new UnsupportedOperationException("Not supported yet.");
        // RYSYJEMY ZAJEBISTE WYKRESYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY!!!!!!!!!!!!
    }

    public void updateTrainingSetMSE(double mse) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void updateGeneralizationSetAccuracy(double accuracy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void updateGeneralizationSetMSE(double mse) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void nextEpoch() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}