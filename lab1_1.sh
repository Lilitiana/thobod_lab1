hadoop fs -mkdir -p /user/root/
hadoop fs -put /1.txt /user/root/
hadoop fs -rm -r ./2
hadoop jar lab1-1.0-jar-with-dependencies.jar 1.txt 2
hadoop fs -cat ./2/part-r-00000