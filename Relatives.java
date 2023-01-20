class Relatives extends People {
    private String id;
    private String generation;
    private String[] info;
    
    Relatives (String id, String gen, String first, String last) {
        super(first, last);
        this.generation = gen;
        this.id = id;
        this.info = new String[] {id, gen, first, last};
    }

    public String getGeneration() {
        return generation;
    }

    public String[] getInfo() {
        return info;
    }

    // @Override
    // public void showInfo(){
    //     System.out.printf("id: %s\n First name: %s\nLast name: %s\nGeneration: %s\n\n", this.info[0], this.info[2], this.info[3], this.info[1]);
    // }
}
