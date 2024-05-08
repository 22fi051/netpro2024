public class NoHolidayException extends Exception{
    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.err.println("休日のため、働きたくありません。");
    }
}
