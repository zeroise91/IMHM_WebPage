package Config;

import java.text.SimpleDateFormat;

/**
 * Created by ParkBeomChan-PC-W1 on 2016-01-14.
*/
    public class DateFormatter {
        private static SimpleDateFormat  ourInstance = new SimpleDateFormat("YYYY년 MM월 DD일 hh시 mm분 ss초");
        public static SimpleDateFormat getInstance() {
            return ourInstance;
        }

        private DateFormatter() {
        }
}
