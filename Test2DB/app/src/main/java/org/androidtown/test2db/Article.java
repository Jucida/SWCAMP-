package org.androidtown.test2db;

/**
 * Created by Administrator on 2017-10-17.
 */

public class Article {

    int articleNumber;
    String title;
    String writer;
    String id;
    String content;
    String writeDate;
    String imgName;

    public Article(int articleNumber, String title, String writer, String id, String content, String writeDate, String imgName){
        this.articleNumber = articleNumber;
        this.title = title;
        this.writer = writer;
        this.id = id;
        this.content = content;
        this.writeDate = writeDate;
        this.imgName = imgName;
    }

    public int getArticleNumber() {
        return articleNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getWriter() {
        return writer;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getWriteDate() {
        return writeDate;
    }

    public String getImgName() {
        return imgName;
    }
}
