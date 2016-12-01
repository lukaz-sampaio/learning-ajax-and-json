package other;

import com.opencsv.CSVReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

/**
 *
 * @author lucas
 */
public class CSVToSQL {

    public static void main(String[] args) {
        String csvFilePath = "src/main/java/other/municipio.csv";
        CSVReader reader = null;
        String[] line;
        Writer writeSqlFile = null;
        try {
            writeSqlFile = new BufferedWriter(new FileWriter(new File("src/main/java/other/teste.sql")));
            reader = new CSVReader(new FileReader(csvFilePath));
            while((line = reader.readNext()) != null){
                String sql = "INSERT INTO tb_municipio VALUES (" + line[1] + ", '" + line[2].replaceAll("'", "''")+ "', " + line[0] + ");\n";
                writeSqlFile.write(sql);
                /** 
                 * A coluna 'id_uf' (line[0]) foi mudada na mão usando o 
                 * replace de algum editor de texto (no meu caso, o gedit) 
                 * depois que o arquivo '.sql' foi escrito
                 */
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writeSqlFile.close();
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
