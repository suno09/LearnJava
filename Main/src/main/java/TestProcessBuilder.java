import java.io.IOException;

public class TestProcessBuilder {
    public static void main(String[] args) throws Exception {
//        String command1 = "mysqladmin create sunmgmt11 -u root --password=0000";
        String command2 = "mysqladmin create sunmgmt12 -u root --password=0000 | mysqldump -u root --password=0000 sunmgmt | mysql -u root --password=0000 sunmgmt12";

        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe ", "/c", command2);
        processBuilder.redirectErrorStream(true);
        Process p = processBuilder.start();
        p.waitFor();

        /*processBuilder = new ProcessBuilder("cmd.exe ", "/c", command2);
        processBuilder.redirectErrorStream(true);
        p = processBuilder.start();
        p.waitFor();*/

        /*try {
            Process p = Runtime
                    .getRuntime()
                    .exec("cmd.exe /c mysqladmin create sunmgmt11 -u root --password=0000 | mysqldump -u root --password=0000 sunmgmt | mysql -u root --password=0000 sunmgmt11");
            p.waitFor();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
    }
}
