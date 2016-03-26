package cafe.model;


public class ReviziaItem {
    private int id;
    private String title;
    private double oldCount;
    private double newCount;
    private double diffCount;

    public ReviziaItem() {
    }

    public ReviziaItem(int id, double oldCount, double newCount, double diffCount) {
        this.id = id;      
        this.oldCount = oldCount;
        this.newCount = newCount;
        this.diffCount = diffCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getOldCount() {
        return oldCount;
    }

    public void setOldCount(double oldCount) {
        this.oldCount = oldCount;
    }

    public double getNewCount() {
        return newCount;
    }

    public void setNewCount(double newCount) {
        this.newCount = newCount;
    }

    public double getDiffCount() {
        return diffCount;
    }

    public void setDiffCount(double diffCount) {
        this.diffCount = diffCount;
    }
    
    
    
}
