package sb_rdtrip_tester;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import org.sbolstandard.core2.SBOLConversionException;
import org.sbolstandard.core2.SBOLDocument;
import org.sbolstandard.core2.SBOLValidate;

public class SBOLTestRunner {

	private TestCollection testCollection; 
	
	public SBOLTestRunner() throws Exception
	{
		initialize_results(); 
	}
	
	public void initialize_results()
	{
		if(!new File("Retrieved/").exists() && !new File("Retrieved/").isDirectory())
			{
				new File("Retrieved/").mkdir();
			}
		if(!new File("Emulated/").exists() && !new File("Emulated/").isDirectory())
			{
				new File("Emulated/").mkdir();
			}
	}
	
	public void writeRetrieved(String name, SBOLDocument doc) throws IOException, SBOLConversionException
	{
		doc.write("Retrieved/" + name); 

	}
	public void writeEmulated(String name, SBOLDocument doc) throws IOException, SBOLConversionException
	{
		doc.write("Retrieved/" + name); 

	}
	
	public Collection<File> run(String collection_type) throws Exception
	{
		testCollection = new TestCollection(); 
		Collection<File> sbol_files = testCollection.get_Collection(collection_type);  //for the set of files, pass it into Emulator	
		return sbol_files;
	}
	
	public void compare(String orig_file, SBOLDocument emulated, SBOLDocument retrieved)
	{
		SBOLValidate.compareDocuments(orig_file + "_Emulated", emulated, orig_file + "_Retrieved", retrieved);
	
	}
	
	
}
