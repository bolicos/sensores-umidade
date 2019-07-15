# REST and MVC version of Spring Sensors of Humidaty Application (sensores-umidade extend ) [![Build Status](https://travis-ci.org/analuciabolico/sensores-umidade.png?branch=master)](https://travis-ci.org/analuciabolico/sensores-umidade/)

In a greenhouse, there are plants with humidity sensors. Each plant needs moisture to be in an ideal range to grow: strawberries: 60% to 80%, cacti: 20% to 50%, mushrooms: 80% to 90%, violets: 40% to 80%, lavender: 20% to 30%. The greenhouse needs a system that notifies when a plant has moisture outside the ideal range

## Running sensores-umidade locally
```
	git clone https://github.com/analuciabolico/sensores-umidade.git
	cd sensores-umidade
	mvn spring-boot:run
```

You can then access sensores-umidade here: http://localhost:8080

## Screenshot of the home page

<img width="1042" alt="greenhouse" src="https://github.com/analuciabolico/sensores-umidade/blob/master/src/main/resources/templates/_images/greenhouse.png">

## In case you find a bug/suggested improvement for Spring Petclinic
Our issue tracker is available here: https://github.com/analuciabolico/sensores-umidade/issues


## Email configuration
In its default configuration of Email.
```
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=sensor.humidity@gmail.com
spring.mail.password=challenge@2019
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
spring.mail.properties.mail.smtp.ssl.enable=false
spring.mail.test-connection=true
```

## Working with Sensors in Eclipse/STS

### prerequisites
The following items should be installed in your system:
* Maven 3 (http://www.sonatype.com/books/mvnref-book/reference/installation.html)
* git command line tool (https://help.github.com/articles/set-up-git)
* Eclipse with the m2e plugin (m2e is installed by default when using the STS (http://www.springsource.org/sts) distribution of Eclipse)

Note: when m2e is available, there is an m2 icon in Help -> About dialog.
If m2e is not there, just follow the install process here: http://eclipse.org/m2e/download/


### Steps:

1) In the command line
```
git clone https://github.com/analuciabolico/sensores-umidade.git
```
2) Inside Eclipse
```
File -> Import -> Maven -> Existing Maven project
```

# Contributing

The [issue tracker](https://github.com/analuciabolico/sensores-umidade/issues) is the preferred channel for bug reports, features requests and submitting pull requests.
