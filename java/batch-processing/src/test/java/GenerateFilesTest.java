import com.github.leventarican.batchprocessing.prototypes.GenerateFiles;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

public class GenerateFilesTest {
    
    @Test
    public void testSomeMethod() {
        try {
            GenerateFiles.generateFolders();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
        Path testEnvironment = FileSystems.getDefault().getPath(GenerateFiles.WORKING_DIR);
        
        // use GenerateFiles.generateDates() or update set from now + 2 days
        Set<String> expected = Set.of("20200213", "20200214", "20200215");
        try {
            /*
            1. list file in WORKING_DIR
            2. filter out sample.file
            3. convert path to string
            4. remove prefix WORKING_DIR
            5. test match
            */
            boolean doesMatch = Files.list(testEnvironment)
                    .filter(p -> !p.equals(testEnvironment.resolve("sample.file")))
                    .map(Object::toString)
                    .map(s -> s.substring(testEnvironment.toString().length()+1))
                    .allMatch(expected::contains);
            assertTrue(doesMatch);
        } catch (IOException ex) {
            System.out.println(ex); // e.g. java.nio.file.NoSuchFileException: WORKING_DIR
        }
    }    
}
