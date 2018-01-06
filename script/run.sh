kill $(ps aux | grep 'spark.jar' | awk '{print $2}')
nohup java -cp spark.jar sdomain.Server &