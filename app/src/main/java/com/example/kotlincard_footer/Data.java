package com.example.kotlincard_footer;

/**
 * Created by rajshekhar on 26/5/16.
 */
public class Data {
    private int imageId;
    private String title;
    private String subtitle;
    private int imageId2;

    public String getTitle_header() {
        return title_header;
    }

    public void setTitle_header(String title_header) {
        this.title_header = title_header;
    }

    private String title_header;


    public Data (Integer imageId, String title, String subtitle, Integer imageId2){
        this.imageId=imageId;
        this.title=title;
        this.subtitle=subtitle;
    }
    public int getImageId2(){
        return imageId2;
    }
    public void setImageId2(int imageId2){
        this.imageId2=imageId2;
    }

    public int getImageId(){
        return imageId;
    }
    public void setImageId(int imageId){
        this.imageId=imageId;
    }



  public String getTitle(){return title;}
    public void setTitle(String title){
        this.title=title;
    }
    public String getSubtitle(){return subtitle;}
    public void setSubtitle(String subtitle){
        this.subtitle=subtitle;
    }


}


//
//private int imageId;
//private String title;
//private String subtitle;
//    public Item(Integer imageId,String title,String subtitle){
//        this.imageId=imageId;
//        this.title =title;
//        this.subtitle=subtitle;
//    }
//    public int getImageId(){
//        return imageId;}
//    public void setImageId(int imageId){
//        this.imageId=imageId;
//    }
//    public String getTitle(){return title;}
//    public void setTitle(String title){
//        this.title=title;
//    }
//    public String getSubtitle(){
//        return subtitle;}
//    public void setSubtitle(String subtitle){
//        this.subtitle=subtitle;
//    }
//}