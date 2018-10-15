package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

import Model.Model;
import View.View;

//This class is for serialization.
/**
 * 
 * @author Wei Zhang
 * @author Yifu Li
 * @author Jiaru Wu
 *
 */
public class ResourceManager {
	/**
	 * 
	 * @param m An instance of model
	 * @throws Exception Exception
	 */
	public static void savemodel (Model m)throws Exception{
		try(ObjectOutputStream oos=new ObjectOutputStream(Files.newOutputStream(Paths.get("data.ser")))){
			oos.writeObject(m);
		} 
	}
	/**
	 * 
	 * @return Returns model which is saved in file
	 * @throws FileNotFoundException If not found the file, call this exception
	 * @throws Exception Exception
	 */
	public static Model loadmodel()throws FileNotFoundException,Exception{
		try(ObjectInputStream ois=new ObjectInputStream(Files.newInputStream(Paths.get("data.ser")))){
			Model m2 =(Model) ois.readObject();
			return m2;
		}
	}
	
}
