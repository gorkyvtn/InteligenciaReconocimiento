import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.Classifier;
import weka.core.Instances;
import weka.core.Instance;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils.DataSource;
/**
 *
 * @author dordonez
 */
public class ClassifierWeka {
    public static final String MODEL = "j48.nist.small.model";
    public static final String STRUCTURE = "structure.arff";
    
    /**
     * @param args the command line arguments
     */
    public String Clasifica(String[] arg) {
        try {
            //carga el modelo
            Classifier cls = (Classifier) SerializationHelper.read(MODEL);
            //carga la estructura de los datos
            Instances dataSet = new DataSource(STRUCTURE).getDataSet();
            dataSet.setClassIndex(dataSet.numAttributes() - 1);
            //crea una instancia vacía y le asigna la estructura
            Instance inst = new Instance(dataSet.numAttributes());
            inst.setDataset(dataSet);
            //carga los datos de la instancia a ser clasificada
            //la forma de cargar los datos de la instancia dependerá de su problema
            String[] s = arg;
            for(int i = 0; i < s.length; i++) {
                double d = Double.parseDouble(s[i]);
                inst.setValue(i, d);
            }
            //clasifica la instancia según el modelo
            double pred = cls.classifyInstance(inst);
            //presenta la clasificación
            System.out.println("Predicción: " + inst.classAttribute().value((int) pred));
            return inst.classAttribute().value((int) pred);
        } catch(Exception e) {
            System.out.println(e);
        }
        return "no def";
    }
    

    
}
