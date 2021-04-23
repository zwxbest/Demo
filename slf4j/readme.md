slf4j找具体的实现

LoggerFactory.getLogger
getILoggerFactory()
performInitialization();
 bind();
 if (!isAndroid()) 
  findPossibleStaticLoggerBinderPathSet()
  Log4jLoggerFactory.getLogger
  Logger newInstance = new Log4jLoggerAdapter(log4jLogger)