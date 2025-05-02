FROM eclipse-temurin:24

# Set working directory
WORKDIR /app

# Install ant and python
RUN apt-get update && \
    apt-get install -y ant python3 && \
    apt-get clean

# Copy all files from 'arithmetic' folder in build context to /app in container
COPY . .

# Build the Java project using Ant
RUN ant clean
RUN ant
# Default command to run your Python runner script
ENTRYPOINT ["./start.sh"]
RUN chmod u+x runner.py start.sh
CMD ["./start.sh"]