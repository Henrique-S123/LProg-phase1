all:
	rm -rf proj/values/*.class proj/parser/*.class proj/ast/*.class proj/*.class
	rm -rf parser
	mkdir parser
	javacc -OUTPUT_DIRECTORY=proj/parser/ proj/parser/ParserL0.jj
	javac -Xlint:unchecked proj/values/*.java proj/parser/*.java proj/ast/*.java proj/*.java

clean:
	rm -rf proj/values/*.class proj/parser/*.class proj/ast/*.class proj/*.class
	rm -rf parser

run:
	java proj/L0int