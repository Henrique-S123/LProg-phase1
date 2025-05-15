all:
	rm -rf proj/values/*.class proj/parser/*.class proj/ast/*.class proj/*.class
	javacc -OUTPUT_DIRECTORY=proj/parser/ proj/parser/ParserL0.jj
	javac -Xlint:unchecked proj/values/*.java proj/parser/*.java proj/ast/*.java proj/*.java

clean:
	rm -rf proj/values/*.class proj/parser/*.class proj/ast/*.class proj/*.class

run:
	java proj/L0int