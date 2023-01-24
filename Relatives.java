class Relatives implements People {

    private String[] info;
    static int[] listID;



    static int[] getListID(int size) {
        int[] list = new int[size];
        int id = 0;

        for (int i = 0; i < list.length; i++)
            list[i] = id++;

        return list;
    }

    static {
        listID = getListID(100);
    }

    Relatives(String[] info) {
        this.info = info;
    }

    public String[] getInfo() {
        return info;
    }
}
