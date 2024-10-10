cd D:\Bijilin\demoQA\demoQA
mvn test


# ==============================================
#       ROOT LOGGING LEVEL & APPENDERS
# ==============================================
log4j.rootCategory=DEBUG, console


# ==============================================
#       CONSOLE
# ==============================================
log4j.appender.console=org.apache.log4j.ConsoleAppender
log4j.appender.console.Threshold=DEBUG
log4j.appender.console.layout=org.apache.log4j.PatternLayout
log4j.appender.console.layout.ConversionPattern=%d{yyyy/MM/dd HH:mm:ss.SSS} [%5p] %-5l - %m%n

# ==============================================
#       FILE.LOG
# ==============================================
#log4j.appender.file=org.apache.log4j.RollingFileAppender
#log4j.appender.file.File=target/logs.log
#log4j.appender.file.MaxFileSize=100MB
#log4j.appender.file.MaxBackupIndex=0
#log4j.appender.file.Append=false
#log4j.appender.file.Threshold=DEBUG
#log4j.appender.file.layout=org.apache.log4j.PatternLayout
#log4j.appender.file.layout.ConversionPattern=%m%n

# ==============================================
#       Special logging directives for individual components
# ==============================================
log4j.logger.org.apache.http=OFF