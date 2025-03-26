#!/bin/bash

# Define variables
SRC_DIR="src/main/java"
OUT_DIR="out"
JAR_FILE="uniquehands.jar"
MAIN_CLASS="edu.canisius.csc213.project1.UniqueHands"

# Clean previous build
echo "🧹 Cleaning previous build..."
rm -rf $OUT_DIR 
mkdir -p $OUT_DIR
# TODO You figure this out

# Compile Java files
echo "🚀 Compiling Java files..."
javac -d $OUT_DIR -sourcpath $SRC_DIR $(find $SRC_DIR -name "*.java")

if  [ $? -ne 0 ]; then 
    echo "X Compilation failed. Please fix errors and try again."
    exit 1
fi

# TODO You figure this out

# Package into a JAR
echo "📦 Creating JAR file..."
jar cfe $JAR_FILE $MAIN_CLASS -c $OUT_DIR .

if  [ $? -ne 0 ]; then 
    echo "X Compilation failed. Please fix errors and try again."
    exit 1
fi
# TODO You figure this out


# Done!
echo "✅ Build complete! Run it with: java -jar $JAR_FILE"