public class TestProcessBuilder {
    public static void main(String[] args) throws Exception {
        String command2 = "mysqladmin create sunmgmt12 -u root --password=0000 | mysqldump -u root --password=0000 sunmgmt | mysql -u root --password=0000 sunmgmt12";

        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe ", "/c", command2);
        processBuilder.redirectErrorStream(true);
        Process p = processBuilder.start();
        p.waitFor();
    }
}
