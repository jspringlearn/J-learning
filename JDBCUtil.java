����   1 Q  com/jdbc/JDBCUtil/JDBCUtil  java/lang/Object ds Ljavax/sql/DataSource; <clinit> ()V Code	      java/util/Properties
     <init>  java/io/FileInputStream  resource/db.properties
     (Ljava/lang/String;)V
     load (Ljava/io/InputStream;)V
    -com/alibaba/druid/pool/DruidDataSourceFactory   ! createDataSource .(Ljava/util/Properties;)Ljavax/sql/DataSource;
 # % $ java/lang/Exception &  printStackTrace LineNumberTable LocalVariableTable p Ljava/util/Properties; in Ljava/io/FileInputStream; e Ljava/lang/Exception;
   this Lcom/jdbc/JDBCUtil/JDBCUtil; getconn ()Ljava/sql/Connection; 5 7 6 javax/sql/DataSource 8 3 getConnection close @(Ljava/sql/Connection;Ljava/sql/Statement;Ljava/sql/ResultSet;)V < > = java/sql/ResultSet 9 
 @ % A java/sql/SQLException C > D java/sql/Statement F > G java/sql/Connection conn Ljava/sql/Connection; st Ljava/sql/Statement; rs Ljava/sql/ResultSet; Ljava/sql/SQLException; 
SourceFile JDBCUtil.java !      	          	   �     +� 
� Y� K� Y� L*+� *� � 
� K*� "�   " % #  '   "             "  &  * ! (        ) *     + ,  &  - .       	   /     *� /�    '        (        0 1   	 2 3  	   N     � 
� 4 �K*� "�     	 #  '       $ 	 & 
 '  ) (     
  - .   	 9 :  	   �     7,� ,� ; � N-� ?+� +� B � N-� ?*� *� E � N-� ?�   
  @    @ ( . 1 @  '   6    ,  . 
 /  0  3  5  6   7 $ 9 ( ; . < 2 = 6 @ (   >    7 H I     7 J K    7 L M    - N     - N  2  - N   O    P