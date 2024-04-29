package PRA;

import java.util.Arrays;
import java.util.Scanner;

public class ipa6 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Book[] b=new Book[4];
        for(int i=0;i<b.length;i++){
            int id=sc.nextInt();
            int pages=sc.nextInt();sc.nextLine();
            String title=sc.nextLine();
            String author=sc.nextLine();
            double price=sc.nextDouble();

            b[i]=new Book(id, pages, title, author, price);
        }
        sc.nextLine();
        String search=sc.nextLine();
        sc.close();
        Book[] res1=findBooksWithMaximumPrice(b);
        if(res1!=null){
            for(int i=0;i<res1.length;i++){
                System.out.println("id:"+res1[i].getId()+" Title:"+res1[i].getTitle());
            }
        } 
        else{
            System.out.println("Null");
        }
    
        Book res2=searchByTitle(b, search);
        if(res2!=null){
            System.out.println("id:"+res2.getId()+" Title:"+res2.getTitle()+" Pages:"+res2.getPages());
        }
        else{
            System.out.println("No Book found with mentioned title.");
        }
    }

    public static Book[] findBooksWithMaximumPrice(Book[] b){
        double max=Double.MIN_VALUE;
        Book[] result=new Book[0];
        for(int i=0;i<b.length;i++){
            if(b[i].getPrice()>max){
                max=b[i].getPrice();
            }
        }
        for(int i=0;i<b.length;i++){
            if(max==b[i].getPrice()){
                result=Arrays.copyOf(result, result.length+1);
                result[result.length-1]=b[i];
            }
        }
        return result.length>0 ? result:null;
    }

    public static Book searchByTitle(Book[] b,String search){
        for(int i=0;i<b.length;i++){
            if(b[i].getTitle().equalsIgnoreCase(search)){
                return b[i];
            }
        }
        return null;
    }
}

class Book{
    int id;
    int pages;
    String title;
    String author;
    double price;

    public Book(int id,int pages,String title,String author,double price){
        this.id=id;
        this.pages=pages;
        this.title=title;
        this.author=author;
        this.price=price;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPages() {
        return this.pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
