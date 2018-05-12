# Requirements

* Set up MySql
	* [in Windows](https://www.roseindia.net/mysql/installing-mysql-on-windows10.shtml)
	* [in most common Linux distros](https://dev.mysql.com/doc/refman/8.0/en/linux-installation.html)

**in Arch Linux setting up both MySql and JDBC can be found [here](https://wiki.archlinux.org/index.php/JDBC_and_MySQL)**

* Set up JDBC
	* [in Windows](https://blogs.msdn.microsoft.com/brian_swan/2011/03/02/getting-started-with-the-sql-server-jdbc-driver/)
	* [in Linux](https://stackoverflow.com/questions/5307048/where-do-i-install-a-jdbc-driver-on-ubuntu)

## Creating your own Database in MySql (optional)

After completing the installations , follow this [link](https://www.liquidweb.com/kb/create-a-mysql-database-on-linux-via-command-line/) and create a database of your own.
Do this if you want to learn working with MySql. Else make use of the already created DB in the given example(s).

## Usage

Its important to note that , when , say you're in Arch Linux, then your default vendor is mariadb , thus in the program you would have to replace "mysql" with "mariadb".
Rest of the execution as same as what had been done with other programs , compile and run `JdbcBeg.java`
