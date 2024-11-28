# Utilizar la imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Copiar los archivos necesarios al contenedor
WORKDIR /app
COPY . /app

# Compilar las clases
RUN javac BMIRemoto.java BMIRemotoImpl.java ServidorRMI.java

# Comando para ejecutar el servidor RMI
CMD ["java", "ServidorRMI"] 

#Seleccionar Puerto
EXPOSE 3000


