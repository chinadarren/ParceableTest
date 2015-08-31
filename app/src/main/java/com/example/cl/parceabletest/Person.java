package com.example.cl.parceabletest;

import android.os.Parcel;
import android.os.Parcelable;

import javax.xml.transform.Source;

/**
 * Created by cl on 2015/8/31.
 */
// Person 类去实现了 Parcelable 接口
public class Person implements Parcelable {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person() {
    }

    private String name;
    private int age;
  //describeContents()方法直接返回 0 就可以
    @Override
    public int describeContents() {
        return 0;
    }
  //writeToParcel()方法中我们需要调用 Parcel 的 writeXxx()方法将
  // Person 类中的字段一一写出
    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(name);//写出name
        parcel.writeInt(age);//写出age

    }
    //必须在 Person 类中提供一个名为 CREATOR 的常量，
    // 这里创建了 Parcelable.Creator接口的一个实现，
    // 并将泛型指定为 Person
    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>(){
   //，在 createFromParcel()方法中我们要去读取刚才写出的 name和 age 字段，
   // 并创建一个 Person对象进行返回
   //其中 name和 age都是调用 Parcel的 readXxx()方法 读取到的，
   // 注意这里读取的顺序一定要和刚才写出的顺序完全相同
        @Override
        public Person createFromParcel(Parcel parcel) {
            Person person = new Person();
            person.name = parcel.readString();//读取name
            person.age = parcel.readInt();//读取age
            return person;
        }

        @Override
        public Person[] newArray(int i) {
            return new Person[i];
        }
    };

}
