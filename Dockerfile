FROM payara/server-full:5.2020.4-jdk11
#COPY --chown=payara:payara postgresql-42.2.5.jar /opt/payara/appserver/glassfish/domains/production/lib
USER root
ADD https://jdbc.postgresql.org/download/postgresql-42.2.5.jar /opt/payara/appserver/glassfish/domains/production/lib
RUN chown payara:payara /opt/payara/appserver/glassfish/domains/production/lib/postgresql-42.2.5.jar
USER payara
COPY --chown=payara:payara payara/domain.xml /opt/payara/appserver/glassfish/domains/production/config
COPY --chown=payara:payara target/fps-ws-concentrador.war $DEPLOY_DIR
# docker build -t concentrador-ee:latest .
