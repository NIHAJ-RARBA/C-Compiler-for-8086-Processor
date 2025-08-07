%option noyywrap
%x CHAR_CHECK
%x STRING_CHECK
%x SINGLE_LINE_COMMENT_CHECK
%x MULTI_LINE_COMMENT_CHECK

%{
    #include <bits/stdc++.h>
    #include "header/symbolTable.cpp"

    using namespace std;

    ofstream logger;
    ofstream tokenstream;

    long long lineCount = 1;
    long long errorCount = 0;
    // long long warningCount = 0;

    SymbolTable symbolTable(7); // 7 buckets as per the matching output

    string currentCharacterLiteral;
    string currentLexeme;
    long long possibleErrorLineNumber = 0;

    string makeUpperCase(const string& str) {
        string upperStr;

        for (char c : str)
        {
            upperStr += toupper(c);
        }


        return upperStr;
    }

    string getKeywordToken(const string& str)  {
        
        if (str == "if") return "IF";
        if (str == "else") return "ELSE";
        if (str == "goto") return "GOTO";
        if (str == "switch") return "SWITCH";
        if (str == "case") return "CASE";
        
        if (str == "for") return "FOR";
        if (str == "while") return "WHILE";
        if (str == "do") return "DO";
        if (str == "break") return "BREAK";
        if (str == "continue") return "CONTINUE";

        if (str == "int") return "INT";
        if (str == "float") return "FLOAT";
        if (str == "char") return "CHAR";
        if (str == "double") return "DOUBLE";
        if (str == "long") return "LONG";
        if (str == "short") return "SHORT";
        if (str == "unsigned") return "UNSIGNED";
        if (str == "static") return "STATIC";

        if (str == "void") return "VOID";
        if (str == "return") return "RETURN";
        if (str == "default") return "DEFAULT";

        // EXTRA KEYWORDS
        if (str == "const") return "CONST";
        if (str == "volatile") return "VOLATILE";
        if (str == "struct") return "STRUCT";
        if (str == "union") return "UNION";


        return "UNRECOGNIZED KEYWORD";
    }

    char convertEscapeSequence(const string& literal)  {
        if (literal.length() == 1)  return literal[0]; // not escape sequence. just a char

        else if (literal.length() == 2)
        {
            switch (literal[1])
            {
                case 'n': return '\n';
                case 't': return '\t';
                case 'v': return '\v';
                case 'r': return '\r';
                case 'f': return '\f';
                case 'a': return '\a';
                case 'b': return '\b';
                case '0': return '\0';
                case '\\': return '\\';
                case '\'': return '\''; // single quote <- got confused once :3
                case '\"': return '\"'; // double quote <- got confused once :3
                default:  
                    return -1; // invalid escape sequence
            }
        }

        return -1; // invalid escape sequence
    }

    void writeToLog(const string& token, const string& lexeme, int lineNumber = lineCount, const string& tokenStreamValueOfString = ""){
        // Line no 1: Token <ID> Lexeme main found <--- format reminder
        string addedPart = "";
        if (tokenStreamValueOfString.length() > 0)
        {
            if (lexeme[0] == '\'' && lexeme[lexeme.length() - 1] == '\'')
            {
                addedPart = " --> <CONST_CHAR, " + tokenStreamValueOfString + ">";
            }
            else addedPart = " --> <STRING, " + tokenStreamValueOfString + ">";
        }
        
        logger << "Line no " << lineNumber << ": Token <" << token << "> Lexeme " << lexeme << " found" << addedPart << endl; 
        logger << endl;
    }

    void writeToTokenStream(const string& token, const string& lexeme){
        // <keyword> or <token, lexeme> <--- format reminder
        tokenstream << "<" << token << ", " << lexeme << "> ";
    }

    void writeKeywordToTokenStream(const string& token){
        // <keyword>
        tokenstream << "<" << token << "> ";
    }

    void writeError(const string& errorMessage, const string& lexeme, int lineNumber = lineCount){
        errorCount++;
        // Error at line no 5: <error message> <erreneous lexeme> <--- format reminder
        logger << "Error at line no " << lineNumber << ": " << errorMessage << " " << lexeme << endl;
        logger << endl;
    }

    void insertToSymbolTable(const string& token, const string& lexeme){
        // < str1 : ID > < str2 : lexeme > <--- format reminder
        if (symbolTable.insert(lexeme, token))
        {
            // logger << endl;
            logger << symbolTable.getAllScopeTablesString();
            logger << endl;
        }
        else
        {
            // logger << endl;
            logger << symbolTable.insertFailureMessage(lexeme, token) << endl;
            logger << endl;
        }
    }

    void endOfFile() {

        // logger << endl;
        // logger << endl;
        logger << symbolTable.getAllScopeTablesString();
        logger << endl;

        logger << "Total lines: " << lineCount << endl;
        logger << "Total errors: " << errorCount << endl;
    }
        

// KEYWORD "if"|"else"|"goto"|"switch"|"case"|"for"|"while"|"do"|"break"|"continue"|"int"|"float"|"char"|"double"|"long"|"short"|"unsigned"|"static"|"void"|"return"|"default"
// BITWISEOP "|"|"&"|"^"|"<<"|">>"|"~"


// UNIX_NEWLINE            \n
// WINDOWS_NEWLINE         \r\n
// OLD_MAC_NEWLINE         \r

%}

NEWLINE                 (\r\n|\r|\n)

WHITESPACE              ([ \t\v\f])+

KEYWORD                 "if"|"else"|"goto"|"switch"|"case"|"for"|"while"|"do"|"break"|"continue"|"int"|"float"|"char"|"double"|"long"|"short"|"unsigned"|"static"|"void"|"return"|"default"|"const"|"volatile"|"struct"|"union"
ADDOP                   "+"|"-"
MULOP                   "*"|"/"|"%"
INCOP                   "++"|"--"
RELOP                   "!="|"<="|">="|"<"|">"
ASSIGNOP                "="
LOGICOP                 "&&"|"||"
NOT                     "!"
LPAREN                  "("
RPAREN                  ")"
LCURL                   "{"
RCURL                   "}"
LTHIRD                  "["
RTHIRD                  "]"
COMMA                   ","
SEMICOLON               ";"


DIGIT                   [0-9]


SINGLE_QUOTE            \'
DOUBLE_QUOTE            \"

SINGLE_LINE_COMMENT_START  "//"
MULTI_LINE_COMMENT_START  \/\*


ID                      [a-zA-Z_][a-zA-Z0-9_]*

INT                     {DIGIT}+
FRACTION                "."{DIGIT}*
NUMBER_WITH_FRACTION    {DIGIT}*{FRACTION}

SCI_NOTATION_EXP        [Ee]{ADDOP}?{DIGIT}+
FLOAT                   ({INT}|{NUMBER_WITH_FRACTION}){SCI_NOTATION_EXP}?


ILL_FORMED_SCI_NOTATION ({INT}|{NUMBER_WITH_FRACTION})[Ee]{ADDOP}?({DIGIT}*{NUMBER_WITH_FRACTION}+)?
TOO_MANY_RADIX_POINTS   {DIGIT}*("."{DIGIT}*){2,}{SCI_NOTATION_EXP}?

NUMBER_STARTING_ID      ({INT}|{NUMBER_WITH_FRACTION}){ID}+




%%







                        
{NEWLINE}                 { lineCount++; }
{WHITESPACE}              { }
{KEYWORD}                 { string token = getKeywordToken(yytext); writeToLog(token, yytext); writeKeywordToTokenStream(token); }

{ADDOP}                   { writeToLog("ADDOP", yytext); writeToTokenStream("ADDOP", yytext); }
{MULOP}                   { writeToLog("MULOP", yytext); writeToTokenStream("MULOP", yytext); }
{INCOP}                   { writeToLog("INCOP", yytext); writeToTokenStream("INCOP", yytext); }
{RELOP}                   { writeToLog("RELOP", yytext); writeToTokenStream("RELOP", yytext); }
{ASSIGNOP}                { writeToLog("ASSIGNOP", yytext); writeToTokenStream      ("ASSIGNOP", yytext); }
{LOGICOP}                 { writeToLog("LOGICOP", yytext); writeToTokenStream("LOGICOP", yytext); }
{NOT}                     { writeToLog("NOT", yytext); writeToTokenStream("NOT", yytext); }
{LPAREN}                  { writeToLog("LPAREN", yytext); writeToTokenStream("LPAREN", yytext); }
{RPAREN}                  { writeToLog("RPAREN", yytext); writeToTokenStream("RPAREN", yytext); }
{LTHIRD}                  { writeToLog("LTHIRD", yytext); writeToTokenStream("LTHIRD", yytext); }
{RTHIRD}                  { writeToLog("RTHIRD", yytext); writeToTokenStream("RTHIRD", yytext); }
{COMMA}                   { writeToLog("COMMA", yytext); writeToTokenStream("COMMA", yytext); }
{SEMICOLON}               { writeToLog("SEMICOLON", yytext); writeToTokenStream("SEMICOLON", yytext); }

{LCURL}                   {
                            writeToLog("LCURL", yytext);
                            writeToTokenStream("LCURL", yytext);
                            symbolTable.enterScope();
                          }


{RCURL}                   {
                            writeToLog("RCURL", yytext);
                            writeToTokenStream("RCURL", yytext);
                            symbolTable.exitScope();
                          }



{INT}                     { 
                            writeToLog("CONST_INT", yytext);
                            writeToTokenStream("CONST_INT", yytext);
                            insertToSymbolTable("CONST_INT", yytext);
                          }

{FLOAT}                   { 
                            writeToLog("CONST_FLOAT", yytext);
                            writeToTokenStream("CONST_FLOAT", yytext);
                            insertToSymbolTable("CONST_FLOAT", yytext);
                          }

{ILL_FORMED_SCI_NOTATION} { writeError("Ill formed number", yytext); logger << endl; }

{NUMBER_STARTING_ID}      { writeError("Invalid prefix on ID or invalid suffix on Number", yytext); }


{TOO_MANY_RADIX_POINTS}   { writeError("Too many decimal points", yytext); logger << endl; }                          

{ID}                      { 
                            writeToLog("ID", yytext);
                            writeToTokenStream("ID", yytext);
                            insertToSymbolTable("ID", yytext);
                          }






{SINGLE_QUOTE}            { currentCharacterLiteral = ""; currentLexeme = yytext; BEGIN CHAR_CHECK; }

<CHAR_CHECK>{
    
    {SINGLE_QUOTE}        {
                                currentLexeme += yytext;

                                if (currentCharacterLiteral.length() == 0)
                                {
                                    writeError("Empty character constant error", currentLexeme); logger << endl;
                                    currentCharacterLiteral = "";
                                    currentLexeme = "";
                                    BEGIN INITIAL;
                                }

                                else if (currentCharacterLiteral.length() == 1 && currentCharacterLiteral[0] == '\\')
                                {
                                    currentCharacterLiteral += yytext;
                                }

                                else if ((currentCharacterLiteral.length() == 2 && currentCharacterLiteral[0] == '\\') 
                                                || (currentCharacterLiteral.length() == 1))
                                {
                                    char escapeSeq = convertEscapeSequence(currentCharacterLiteral);

                                    if (escapeSeq == -1)
                                    {
                                        writeError("Invalid escape sequence", currentLexeme); logger << endl;
                                    }
                                    else
                                    {
                                        currentCharacterLiteral = "";
                                        currentCharacterLiteral += escapeSeq;
                                        writeToLog("CONST_CHAR", currentLexeme, lineCount, currentCharacterLiteral);
                                        writeToTokenStream("CONST_CHAR", currentCharacterLiteral);
                                        insertToSymbolTable("CONST_CHAR", currentLexeme);
                                    }

                                    currentLexeme = "";
                                    currentCharacterLiteral = "";
                                    BEGIN INITIAL;
                                }

                                else if (currentCharacterLiteral.length() > 1)
                                {
                                    writeError("Multi character constant error", currentLexeme); logger << endl;
                                    currentCharacterLiteral = "";
                                    currentLexeme = "";
                                    BEGIN INITIAL;
                                }
                          }


  

  
  [^\r\n{SINGLE_QUOTE}]   {
                                currentCharacterLiteral += yytext;
                                currentLexeme += yytext;
                          }

    {NEWLINE}             { 
                                writeError("Unterminated character", currentLexeme); logger << endl;
                                lineCount++;
                                currentCharacterLiteral = "";
                                currentLexeme = "";
                                BEGIN INITIAL;
                          }

    <<EOF>>               { 
                                writeError("Unterminated character", currentLexeme); logger << endl;
                                currentCharacterLiteral = "";
                                currentLexeme = "";
                                
                                endOfFile();

                                // BEGIN INITIAL;
                                return 0;
                          }



}

{DOUBLE_QUOTE}            { possibleErrorLineNumber = lineCount; currentLexeme = yytext; currentCharacterLiteral = ""; BEGIN STRING_CHECK; }


<STRING_CHECK>{

    

    
    \\[^ \r\n]             {
                                currentLexeme += yytext;
                                // tokenstream << endl << yytext << "HI";

                                char escapeSeq = convertEscapeSequence(yytext);

                                if (escapeSeq == -1)
                                {
                                    currentCharacterLiteral += yytext;
                                }
                                else if (escapeSeq == '\b' && currentCharacterLiteral.length() > 0)
                                {
                                    currentCharacterLiteral.pop_back();
                                }
                                else
                                {
                                    currentCharacterLiteral.push_back(escapeSeq);
                                }
                          }

    \\{NEWLINE}                 {
                                        lineCount++;
                                        currentLexeme += yytext;
                                }                          

    
    {DOUBLE_QUOTE}         {
                                    currentLexeme += yytext;
                                    // strip the double quotes
                                    // currentLexeme = currentLexeme.substr(1, currentLexeme.length() - 2);

                                    writeToLog("STRING", currentLexeme, lineCount, currentCharacterLiteral);
                                    writeToTokenStream("STRING", currentCharacterLiteral);

                                    currentCharacterLiteral = "";
                                    possibleErrorLineNumber = 0;
                                    currentLexeme = "";
                                    BEGIN INITIAL;
                           }
                           
                        

    {NEWLINE}             {
                                writeError("Unterminated string", currentLexeme, possibleErrorLineNumber);
                                
                                lineCount++;
                                currentCharacterLiteral = "";
                                currentLexeme = "";
                                BEGIN INITIAL;
                          }
    [^\r\n{DOUBLE_QUOTE}] {
                                // tokenstream << endl << yytext << "HI";
                                currentCharacterLiteral += yytext;
                                currentLexeme += yytext;
                          }

    <<EOF>>               { 
                                writeError("Unterminated string", currentLexeme, possibleErrorLineNumber); 
                                currentCharacterLiteral = "";
                                currentLexeme = "";
                                
                                endOfFile();
                                // BEGIN INITIAL;
                                return 0;
                          }

    


}

{SINGLE_LINE_COMMENT_START}[^\r\n]*  { writeToLog("COMMENT", yytext); }

{SINGLE_LINE_COMMENT_START}[^\r\n]*\\{NEWLINE} { 
                                        possibleErrorLineNumber = lineCount;
                                        lineCount++;
                                        currentLexeme += yytext;
                                        BEGIN SINGLE_LINE_COMMENT_CHECK;                
                                     }
<SINGLE_LINE_COMMENT_CHECK>{

    {NEWLINE}             { 
                                writeToLog("COMMENT", currentLexeme);
                                lineCount++;
                                currentLexeme = "";
                                BEGIN INITIAL;
                          }

    <<EOF>>               { 

                                writeToLog("COMMENT", currentLexeme);
                                currentLexeme = "";
                                
                                endOfFile();

                                // BEGIN INITIAL;
                                return 0;
                          }
    [^\r\n]*              { currentLexeme += yytext; }




}                                     

{MULTI_LINE_COMMENT_START}   { 
                                possibleErrorLineNumber = lineCount;
                                currentLexeme = yytext;
                                BEGIN MULTI_LINE_COMMENT_CHECK;                
                             }

<MULTI_LINE_COMMENT_CHECK>{
    

    "*/"                  {      
                                
                                currentLexeme += yytext;
                                writeToLog("COMMENT", currentLexeme, lineCount);
                                possibleErrorLineNumber = 0;
                                currentLexeme = "";
                          
                                BEGIN INITIAL;
                             }
    
    {NEWLINE}                { 
                                lineCount++;
                                currentLexeme += yytext;
                             }

    .                        { currentLexeme += yytext; }




    <<EOF>>               { 
                                writeError("Unterminated comment", currentLexeme, possibleErrorLineNumber); 
                                currentLexeme = "";
                                possibleErrorLineNumber = 0;
                                
                                endOfFile();
                                // BEGIN INITIAL;
                                return 0;
                          }

}





<<EOF>> { endOfFile(); return 0; }

            .          {
                            writeError("Unrecognized character", yytext);
                       }




%%







int main(int argc, char* argv[])
{
    if (argc != 2)
    {
        cout << "Usage: " << argv[0] << " <input_file>" << endl;
        return 1;
    }

    FILE *inputFile = fopen(argv[1], "r");
    if (inputFile == nullptr)
    {
        cerr << "Error opening file: " << argv[1] << endl;
        return 1;
    }

    logger.open("2105055_log.txt");
    if (!logger.is_open())
    {
        cerr << "Error opening log file." << endl;
        fclose(inputFile);
        return 1;
    }
    tokenstream.open("2105055_tokenstream.txt");
    if (!tokenstream.is_open())
    {
        cerr << "Error opening token stream file." << endl;
        fclose(inputFile);
        return 1;
    }

    yyin = inputFile;
    yylex();
    fclose(inputFile);
    logger.close();
    tokenstream.close();
    return 0;
}