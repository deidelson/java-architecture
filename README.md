1 install docker
2 docker pull mariadb
3 docker container run -d --name mariadb -e MYSQL_ROOT_PASSWORD=mypass mariadb
4 run the script in resources

You can also install mariadb manually and change jpa properties in spring boot properties