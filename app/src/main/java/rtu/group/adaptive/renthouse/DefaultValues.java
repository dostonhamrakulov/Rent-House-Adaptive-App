package rtu.group.adaptive.renthouse;

/*
 *   Created by Doston Hamrakulov
 */
public class DefaultValues {




    public static final String[] CITY = {"Riga","Yurmala", "Ventspils", "Riga","Yurmala", "Ventspils", "Riga","Yurmala", "Ventspils", "Riga","Yurmala", "Ventspils",
            "Riga","Riga", "Riga", "Riga","Yurmala", "Riga", "Riga","Riga", "Ventspils", "Riga","Riga", "Riga"};//8*3=24
    public static final String[] NUM_ROOMS = {"5", "3", "4", "2", "4", "1", "1", "2", "3", "4", "2", "3", "5", "2", "2", "3", "4", "5",
            "5", "3", "4", "2", "5", "3", "2", "3", "2", "3", "4", "3"};
    public static final String[] PRICE= {"159", "500", "230", "350", "450", "225", "180", "190", "230", "230", "600", "225", "210", "200", "230", "255", "275", "280",
            "300", "400", "230", "350", "450", "225", "241", "236", "187", "310", "271", "250"};
    public static final String[] MIN_PERIOD = {"12", "6", "12", "6", "12", "6", "12", "6", "12", "6", "12", "6", "12", "6", "12", "6", "12", "6", "12", "6", "12", "6", "12", "6",
            "12", "6", "12", "6", "12", "6", "12", "6"};
    public static final String[] FLOOR = {"1", "5", "6", "4", "2", "7", "5", "6", "4", "2", "9", "5", "6", "4", "2", "9", "5", "6", "4", "1", "3", "5", "6", "4", "2",
            "1", "5", "6", "5", "2", "8", "9", "8", "5", "12"};
    public static final String[] ADDRESSES = {"Kalku 1/312", "Setas 1/208", "Davgavpils 2/529", "Kalku 1/312", "Setas 1/208", "Davgavpils 2/529",
            "Kalku 1/312", "Setas 1/208", "Davgavpils 2/529",
            "Kalku 1/312", "Setas 1/208", "Davgavpils 2/529",
            "Kalku 1/312", "Setas 1/208", "Davgavpils 2/529",
            "Kalku 1/312", "Setas 1/208", "Davgavpils 2/529",
            "Kalku 1/312", "Setas 1/208", "Davgavpils 2/529",
            "Kalku 1/312", "Setas 1/208", "Davgavpils 2/529",
            "Kalku 1/312", "Setas 1/208", "Davgavpils 2/529",
            "Kalku 1/312", "Setas 1/208", "Davgavpils 2/529",};
    public static final String[] PHONESES = {"+371 28000000", "+371 28000000", "+371 28000000", "+371 28000000", "+371 28000000",
            "+371 28000000", "+371 28000000", "+371 28000000", "+371 28000000", "+371 28000000", "+371 28000000", "+371 28000000",
            "+371 28000000", "+371 28000000", "+371 28000000", "+371 28000000", "+371 28000000", "+371 28000000", "+371 28000000",
            "+371 28000000", "+371 28000000", "+371 28000000", "+371 28000000", "+371 28000000", "+371 28000000", "+371 28000000"};

    public DefaultValues() {

    }

    public String getCITY(int i) {
        return CITY[i];
    }

    public String getNUM_ROOMS(int i) {
        return NUM_ROOMS[i];
    }

    public String getPRICE(int i) {
        return PRICE[i];
    }

    public String getMIN_PERIOD(int i) {
        return MIN_PERIOD[i];
    }

    public String getFLOOR(int i) {
        return FLOOR[i];
    }
    public String getADDRESSES(int i) {
        return ADDRESSES[i];
    }
    public String getPHONES(int i) {
        return PHONESES[i];
    }

}
