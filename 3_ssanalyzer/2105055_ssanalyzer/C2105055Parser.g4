// parser grammar C8086Parser;
parser grammar C2105055Parser;

options {
    // tokenVocab = C8086Lexer;
    tokenVocab = C2105055Lexer;
}

@parser::header {
    #pragma once
    #include <iostream>
    #include <fstream>
    #include <string>
    #include <cstdlib>
    // #include "C8086Lexer.h"
    #include "C2105055Lexer.h"
    #include "headers/SymbolTable.hpp"
    #include "headers/str_list.cpp"

    using namespace std;

    

	

    extern std::ofstream parserLogFile;
    extern std::ofstream errorFile;

	extern std::ofstream ssaLogFile;
    extern std::ofstream ssaErrorFile;


    extern std::ofstream asmFile;
    extern std::ofstream tempFile;
    
    

}

@parser::members {
    
    SymbolTable* symbolTable;
    bool insideNewScope; 
    string currentType;
    string currentFunction;
    string funcRetType;
    stack<string> retTypeStack;

    int syntaxErrorCount;
    int semanticErrorCount;
    bool insideLoop; // made in a rush, so, only detects error for one loop at a time,
                     // for nested, would need to use a counter, when it hits 0, 
                     // it will detect break/continue outside loop error accordingly
    
    int loopNestingLevel = 0; // for nested loops, to detect break/continue outside loop error



    
    void writeIntoparserLogFile(const std::string message) {
        if (!parserLogFile) {
            std::cout << "Error opening parserLogFile.txt" << std::endl;
            return;
        }

        parserLogFile << message << std::endl;
        parserLogFile.flush();
    }

    void writeIntoErrorFile(const std::string message) {
        if (!errorFile) {
            std::cout << "Error opening errorFile.txt" << std::endl;
            return;
        }
        errorFile << message << std::endl;
        errorFile.flush();
    }

	void logSSA(int line, const std::string rule, const std::string message) {
		if (!ssaLogFile) {
			std::cout << "Error opening ssaLogFile.txt" << std::endl;
			return;
		}
		ssaLogFile << "Line " << line << ": " << rule << std::endl 
                    << std::endl << message << std::endl
                    << std::endl;
		ssaLogFile.flush();
	}

    void logSSA(const std::string message) {
        if (!ssaLogFile) {
            std::cout << "Error opening ssaLogFile.txt" << std::endl;
            return;
        }
        ssaLogFile << message << std::endl;
        ssaLogFile.flush();
    }

    void eofLogSSA(int line, string message) {
        if (!ssaLogFile) {
            std::cout << "Error opening ssaLogFile.txt" << std::endl;
            return;
        }
        ssaLogFile << "Line " << line << ": " << message << std::endl
                    << std::endl;
    }

    void logError(int line, const std::string message) {
        if (!ssaErrorFile) {
            std::cout << "Error opening ssaErrorFile.txt" << std::endl;
            return;
        }

        ssaLogFile << "Error at line " << line << ": " 
                     << message << std::endl
                     << std::endl;
        ssaLogFile.flush();

        ssaErrorFile << "Error at line " << line << ": " 
                     << message << std::endl
                     << std::endl;
        ssaErrorFile.flush();
    }


    void logAndErrorType2(int line, const std::string rule, const std::string errorMessage, const std::string code) {
        if (!ssaLogFile) {
			std::cout << "Error opening ssaLogFile.txt" << std::endl;
			return;
            
		}

         if (!ssaErrorFile) {
            std::cout << "Error opening ssaErrorFile.txt" << std::endl;
            return;
        }

		ssaLogFile << "Line " << line << ": " << rule << std::endl 
                    << std::endl;
        ssaLogFile << "Error at line " << line << ": " 
                     << errorMessage << std::endl
                     << std::endl;
        ssaLogFile << code << endl
                    << std::endl;
		ssaLogFile.flush();

        ssaErrorFile << "Error at line " << line << ": " 
                     << errorMessage << std::endl
                     << std::endl;
        ssaErrorFile.flush();

    }
            


    void insertFunctionParam(int line, str_list paramList, str_list typeList) {

        vector<string> types = typeList.get_variables();
        for (const string& param : paramList.get_variables())
        {
            if (!symbolTable->insert(param, "ID")) {
                logError(line, "Multiple declaration of " + param + " in parameter");
                semanticErrorCount++;
            }
            else {
                SymbolInfo* paramSymbol = symbolTable->lookUp(param);
                if (paramSymbol) {
                    paramSymbol->interpretedType = types[0];
                }
            }
        }
    }



}


start   :
        {
            syntaxErrorCount = 0;
            semanticErrorCount = 0;    
            symbolTable = new SymbolTable(7);
            insideNewScope = false;
            currentType = "";
            currentFunction = "";
            funcRetType = "";
            
            retTypeStack = stack<string>();
            insideLoop = false;
            loopNestingLevel = 0; 
            

        }
        prog=program 
        {
            // writeIntoparserLogFile(
            //     "Parsing completed successfully with " + 
            //     std::to_string(syntaxErrorCount) + " syntax errors.");

            int errorCount = syntaxErrorCount + semanticErrorCount;

            
            std::cout << "hi " << errorCount<< "\n" << _ctx->getText() << std::endl;

            eofLogSSA(_input->LT(-1)->getLine(), "start : program");
            logSSA(symbolTable->getAllScopeTablesString());
            // logSSA(_ctx->getText());

            logSSA("Total number of lines: " + 
                std::to_string(_input->LT(-1)->getLine()));
            logSSA("Total number of errors: " + std::to_string(errorCount));

        }
;


program returns [std::string programStr]: 
        p=program u=unit 
        {
            $programStr = $p.programStr + "\n" + $u.unitStr;
            // // std::cout << "$u.unitStr: " << $programStr << std::endl;
            logSSA(_input->LT(-1)->getLine(), "program : program unit", 
                $programStr);
        } #PROGRAM_PROGRAM_UNIT
        | u=unit 
        {
            $programStr = $u.unitStr;
            // std::cout << "$u.unitStr: " << $u.unitStr << std::endl;
            logSSA(_input->LT(-1)->getLine(), "program : unit", 
                $programStr);
        } #PROGRAM_UNIT
;


	
unit returns [std::string unitStr]: 
        vd=var_declaration 
        {
            $unitStr = $vd.varDecStr;
            // std::cout << "$vd.varDecStr: " << $vd.varDecStr << std::endl;
            logSSA(_input->LT(-1)->getLine(), "unit : var_declaration", $vd.varDecStr);
        } #UNIT_VAR_DECLARATION
        | funcDec=func_declaration
        {
            $unitStr = $funcDec.funcDeclarationStr;
            // std::cout << "$funcDec.funcDeclarationStr: " << $funcDec.funcDeclarationStr << std::endl;
            logSSA(_input->LT(-1)->getLine(), "unit : func_declaration", $unitStr);
            // writeIntoparserLogFile("Function Declaration: " + $unitStr);
        } #UNIT_FUNC_DECLARATION
        | funcDef=func_definition
        {
            $unitStr = $funcDef.funcDefStr;
            // std::cout << "$funcDef.funcDefStr: " << $funcDef.funcDefStr << std::endl;
            logSSA(_input->LT(-1)->getLine(), "unit : func_definition", $unitStr);
            // writeIntoparserLogFile("Function Definition: " + $unitStr);
        } #UNIT_FUNC_DEFINITION
        | structDec=struct_declaration
        {
            $unitStr = $structDec.structDeclarationStr;
            logSSA(_input->LT(-1)->getLine(), "unit : struct_declaration", $unitStr);
        } #UNIT_STRUCT_DECLARATION
        | statement
        {
            $unitStr = $statement.stmtStr;
            logSSA(_input->LT(-1)->getLine(), "unit : statement", $unitStr);
        } #UNIT_STATEMENT
;
     
func_declaration returns [std::string funcDeclarationStr]: 
            ts=type_specifier ID LPAREN pl=parameter_list RPAREN SEMICOLON
            {
                $funcDeclarationStr = $ts.type + " " + $ID->getText() + "(" + $pl.paramListStr.get_list_as_string() + ");";
                logSSA(_input->LT(-1)->getLine(), "func_declaration : type_specifier ID LPAREN parameter_list RPAREN SEMICOLON",
                    $funcDeclarationStr);

                if(symbolTable->insert($ID->getText(), "ID") == false)
                {
                    logError(_input->LT(-1)->getLine(), "Multiple declaration of " + $ID->getText());
                    semanticErrorCount++;
                }
                else
                {
                    currentFunction = $ID->getText();
                    SymbolInfo* func = symbolTable->lookUp($ID->getText());
                    func->makeFunctionSymbol($ts.type, $pl.typeList.get_variables(), $pl.paramList.get_variables());
                    // cout << $pl.typeList.get_list_as_string() << endl << $pl.paramList.get_list_as_string() << endl;
                }
                funcRetType = $ts.type;




                



                // writeIntoparserLogFile("Function Declaration: " + $funcDeclarationStr);
            } #FUNCDECLARATION_WITH_PARAM_LIST
            | ts=type_specifier ID LPAREN RPAREN SEMICOLON
            {
                $funcDeclarationStr = $ts.type + " " + $ID->getText() + "();";
                logSSA(_input->LT(-1)->getLine(), "func_declaration : type_specifier ID LPAREN RPAREN SEMICOLON",
                    $funcDeclarationStr);
                if(symbolTable->insert($ID->getText(), "ID") == false)
                {
                    logError(_input->LT(-1)->getLine(), "Multiple declaration of " + $ID->getText());
                    semanticErrorCount++;
                }
                else
                {
                    currentFunction = $ID->getText();
                    SymbolInfo* func = symbolTable->lookUp($ID->getText());
                    func->makeFunctionSymbol($ts.type, {}, {});
                }
                funcRetType = $ts.type;

                // writeIntoparserLogFile("Function Declaration: " + $funcDeclarationStr);
            } #FUNCDECLARATION_WITHOUT_PARAM_LIST
            // | type_specifier ID LPAREN parameter_list
;
		 

func_definition returns [std::string funcDefStr]: 
        {
            SymbolInfo* func = nullptr;
            bool willShowDeclarationError = false;
        }
        ts=type_specifier ID
        {
            func = symbolTable->lookUp($ID->getText());
            // funcRetType = $ts.type;
            retTypeStack.push($ts.type);

            if (!func)
            {
                symbolTable->insert($ID->getText(), "ID");
                func = symbolTable->lookUp($ID->getText());
                currentFunction = $ID->getText();
                func->interpretedType = $ts.type;
                funcRetType = func->interpretedType;

            }
            else
            {
                if ((func->isFunction && func->definedFunction)
                   || (func->isFunction == false))
                {
                    // logError(_input->LT(-1)->getLine(), "Multiple declaration of " + $ID->getText());
                    // semanticErrorCount++;
                    willShowDeclarationError = true;
                }
            }
            
            symbolTable->enterScope();
            insideNewScope = true; 

            

            
        }
        LPAREN pl=parameter_list RPAREN
        {
            if(willShowDeclarationError)
            {
                logError(_input->LT(-1)->getLine(), "Multiple declaration of " + $ID->getText());
                semanticErrorCount++;
            }
            // func->setFunctionDefined();
            // func = symbolTable->lookUp($ID->getText());
            bool willSetDefined = true;
            // if ((func->isFunction && func->definedFunction) || (func->isFunction == false))
            // {
            //     willSetDefined = false;
            //     logError(_input->LT(-1)->getLine(), "Multiple definition of " + $ID->getText());
            //     semanticErrorCount++;
            // }
            // else 
            if (func->isFunction && !func->definedFunction)
            {
                if (funcRetType != $ts.type)
                {
                    willSetDefined = false;
                    cout << "func type check: " << funcRetType << " " << $ts.type << endl;
                    logError(_input->LT(-1)->getLine(), "Return type mismatch of " + $ID->getText());
                    semanticErrorCount++;
                }
                else if (func->parameters.size() != $pl.paramList.get_variables().size())
                {
                    funcRetType = func->interpretedType;


                    willSetDefined = false;
                    cout << "WTFF" << endl;
                    for(int i = 0; i < func->parameters.size(); ++i)
                    {
                        cout << func->parameters[i].first << " " << func->parameters[i].second << endl;
                    }
                    // cout << func->parameters[i].first
                     cout << " " << $pl.paramList.get_list_as_string() << endl;
                    logError(_input->LT(-1)->getLine(), "Total number of arguments mismatch with declaration in function " + $ID->getText());
                    semanticErrorCount++;
                }
                else
                {
                    funcRetType = func->interpretedType;
                    for (size_t i = 0; i < func->parameters.size(); ++i) {
                        if (func->parameters[i].second != $pl.typeList.get_variables()[i]) {
                            willSetDefined = false;
                            logError(_input->LT(-1)->getLine(), to_string(i+1) + "th argument type mismatch with declaration in function " + $ID->getText());
                            semanticErrorCount++;
                            break;
                        }

                    }
                }
            }
            if(willSetDefined) 
            {
                func->makeFunctionSymbol(funcRetType, $pl.typeList.get_variables(), $pl.paramList.get_variables());
            }
                func->setFunctionDefined(); // why are we letting wrong functions still be called defined tho?

            // symbolTable->enterScope();
            // insideNewScope = true; 

            // insertFunctionParam(_input->LT(-1)->getLine(), $pl.paramList, $pl.typeList);
        }
        compStmt=compound_statement
        {
            $funcDefStr = $ts.type + " " + $ID->getText() + "(" + $pl.paramListStr.get_list_as_string() + ")" + $compStmt.compoundStmtStr;
            
            retTypeStack.pop();

            if($compStmt.compoundStmtStr.find("return") != std::string::npos)
            {
                if($ts.type == "void")
                {
                    logError(_input->LT(-1)->getLine(), "Cannot return value from function " + currentFunction + " with void return type");
                    semanticErrorCount++;
                }
            }

            logSSA(_input->LT(-1)->getLine(), "func_definition : type_specifier ID LPAREN parameter_list RPAREN compound_statement",
            $funcDefStr);

            // if(!$pl.err)
            // {
            // logSSA(_input->LT(-1)->getLine(), "func_definition : type_specifier ID LPAREN parameter_list RPAREN compound_statement",
            // $funcDefStr);
            // }
            // else
            // {
            //     logSSA(_input->LT(-1)->getLine(), "func_definition : type_specifier ID LPAREN RPAREN compound_statement",
            //     $funcDefStr);   
            // }     


        } #FUNC_DEF_WITH_PARAM_LIST
		| ts=type_specifier ID 
        LPAREN
        {
            bool success = symbolTable->insert($ID->getText(), "ID");
            cout << success << " " << $ID->getText() << endl;

            retTypeStack.push($ts.type);
            
            if(success == false)
            {
                funcRetType = $ts.type;     
                SymbolInfo* func = symbolTable->lookUp($ID->getText());
                // cout << "touche?" << endl;
                if(func)
                {
                    if(func->isFunction && func->definedFunction)
                    {
                        logError(_input->LT(-1)->getLine(), "Multiple declaration of " + $ID->getText());
                        semanticErrorCount++;
                    }
                }
            }
            else
            {
                SymbolInfo* func = symbolTable->lookUp($ID->getText());
                func->makeFunctionSymbol($ts.type, {}, {});
                func->setFunctionDefined();
                currentFunction = $ID->getText();
            }

            

        }
        RPAREN
        {
                        
            symbolTable->enterScope();
            insideNewScope = true; 
        }
        compStmt=compound_statement
        {
            $funcDefStr = $ts.type + " " + $ID->getText() + "()" + $compStmt.compoundStmtStr;

            retTypeStack.pop();
            
            if($compStmt.compoundStmtStr.find("return") != std::string::npos)
            {
                if($ts.type == "void")
                {
                    logError(_input->LT(-1)->getLine(), "Cannot return value from function " + currentFunction + " with void return type");
                    semanticErrorCount++;
                }
            }

            logSSA(_input->LT(-1)->getLine(), "func_definition : type_specifier ID LPAREN RPAREN compound_statement", $funcDefStr);


            
        } #FUNC_DEF_WITHOUT_PARAM_LIST
;

parameter_list returns [str_list paramListStr, str_list paramList, str_list typeList, bool err]: 
            pl=parameter_list COMMA ts=type_specifier ID
            {
                
                $paramList.set_variables($pl.paramList.get_variables());
                $paramList.add($ID->getText());

                $paramListStr.set_variables($pl.paramListStr.get_variables());
                $paramListStr.add($ts.type + " " + $ID->getText());

                $typeList.set_variables($pl.typeList.get_variables());
                $typeList.add($ts.type);
            
                if(insideNewScope)
                {
                    if (!symbolTable->insert($ID->getText(), "ID")) {
                        logError(_input->LT(-1)->getLine(), "Multiple declaration of " + $ID->getText() + " in parameter");
                        semanticErrorCount++;
                    }   
                    else {
                        SymbolInfo* var = symbolTable->lookUp($ID->getText());
                        if(var)
                        {
                             var->interpretedType = $ts.type;
                        }
                    }
                }
                $err = false;
                logSSA(_input->LT(-1)->getLine(), "parameter_list : parameter_list COMMA type_specifier ID",
                        $paramListStr.get_list_as_string());
            } #PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIER_ID
            | pl=parameter_list COMMA ts=type_specifier
            {
                $paramList.set_variables($pl.paramList.get_variables());
                $paramListStr.set_variables($pl.paramListStr.get_variables());

                $paramListStr.add($ts.type);
                $typeList.set_variables($pl.typeList.get_variables());
                $typeList.add($ts.type);
                $err = false;
                logSSA(_input->LT(-1)->getLine(), "parameter_list : parameter_list COMMA type_specifier",
                        $paramListStr.get_list_as_string());
            } #PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIER
            | ts=type_specifier ID
            {
                $paramList.set_variables({$ID->getText()});
                $paramListStr.add($ts.type + " " + $ID->getText());

                $typeList.add($ts.type);

                if(insideNewScope)
                {
                    if (!symbolTable->insert($ID->getText(), "ID")) {
                        logError(_input->LT(-1)->getLine(), "Multiple declaration of " + $ID->getText() + " in parameter");
                        semanticErrorCount++;
                    }
                    else {
                        SymbolInfo* var = symbolTable->lookUp($ID->getText());
                        if(var)
                        {
                            var->interpretedType = $ts.type;
                        }
                    }
                }

                $err = false;
                logSSA(_input->LT(-1)->getLine(), "parameter_list : type_specifier ID",
                        $paramListStr.get_list_as_string());
            } #PARAMLIST_TYPE_SPECIFIER_ID
            | ts=type_specifier
            {

                $paramListStr.add($ts.type);
                $paramList.add("");
                $typeList.add($ts.type);

                cout << $paramListStr.get_list_as_string() << endl;
                cout << "paramlist" << $paramList.get_list_as_string() << endl;
                cout << $typeList.get_list_as_string() << endl;
                $err = false;
                logSSA(_input->LT(-1)->getLine(), "parameter_list : type_specifier",
                        $paramListStr.get_list_as_string());
            } #PARAMLIST_TYPE_SPECIFIER
            | pl=parameter_list ADDOP
            {
                $paramListStr.set_variables($pl.paramListStr.get_variables());
                $paramList.set_variables($pl.paramList.get_variables());
                $typeList.set_variables($pl.typeList.get_variables());
                cout << "err" << endl;
                cout << $paramListStr.get_list_as_string() << endl;
                cout << $paramList.get_list_as_string() << endl;
                cout << $typeList.get_list_as_string() << endl;
                logError(_input->LT(-1)->getLine(), "syntax error, unexpected ADDOP, expecting RPAREN or COMMA");
                syntaxErrorCount++;
                
                $err = true;
                // $paramListStr.set_variables({});
                // $paramList.set_variables({});
                // $typeList.set_variables({});
            } #PARAMLIST_error // shouldn't happen for icg offline
            // |
            // {
            //     $paramListStr.set_variables({});
            //     $paramList.set_variables({});
            //     $typeList.set_variables({});

            // }
;

 		
compound_statement returns [std::string compoundStmtStr]
        :
        LCURL 
        {
            if(!insideNewScope)
            {
                symbolTable->enterScope();
            } 
            insideNewScope = false;

            // symbolTable->enterScope();
            // insideNewScope = false;

        }
        multiStmt=statements RCURL
        {  

            $compoundStmtStr = $LCURL->getText()+"\n" + $multiStmt.multiStmtStr + "\n" + $RCURL->getText();
            logSSA(_input->LT(-1)->getLine(), "compound_statement : LCURL statements RCURL", $compoundStmtStr);

            logSSA(symbolTable->getAllScopeTablesString());
            symbolTable->exitScope();
            // insideNewScope = false; 
        } #COMPSTMT_STATEMENTS
        | LCURL
        {
            if(!insideNewScope)
            {
                symbolTable->enterScope();
            }
            insideNewScope = false;

             // symbolTable->enterScope(); insideNewScope = false; 
        }  
        RCURL 
        {
            $compoundStmtStr = $LCURL->getText() + $RCURL->getText();
            logSSA(_input->LT(-1)->getLine(), "compound_statement : LCURL RCURL", $compoundStmtStr);

            logSSA(symbolTable->getAllScopeTablesString());

            symbolTable->exitScope(); 
            // insideNewScope = false;

        } #COMPSTMT_EMPTY
;



var_declaration returns[std::string varDecStr, string type]:
        t=type_specifier dl=declaration_list sm=SEMICOLON
        {
            // writeIntoparserLogFile(
            //     std::string("Variable Declaration: type_specifier declaration_list ") +
            //     std::to_string($sm->getType()) +
            //     " at line " + std::to_string($sm->getLine())
            // );

            $type = $t.type;
            bool errorDisplayType2 = false;

            if($type == "void")
            {
                // logError(_input->LT(-1)->getLine(), "Variable type cannot be void");
                errorDisplayType2 = true;
                semanticErrorCount++;
            }

            SymbolInfo* var = nullptr;
            vector<string> variables = $dl.retList.get_variables();
            for(int i = 0; i < variables.size(); i++)
            {
                var = symbolTable->lookUp(variables[i]);
                if(var)
                {
                    var->interpretedType = $type;
                }
            }
            // for(int i = 0; i < variables.size(); i++)
            // {
            //     var = symbolTable->lookUp(variables[i]);
            //     cout << "Var type updated?? " << var->getSymbolName() << " " << var->interpretedType << endl;
            // }

            $varDecStr = $t.type + " " + $dl.varList.get_list_as_string() + ";";
            if(errorDisplayType2 == false)
            {
                logSSA($sm->getLine(), "var_declaration : type_specifier declaration_list SEMICOLON", 
                $varDecStr);
            }
            else
            {    
                logAndErrorType2(_input->LT(-1)->getLine(), "var_declaration : type_specifier declaration_list SEMICOLON", "Variable type cannot be void",
                    $varDecStr);
            }
        } #VARDEC_TYPE_SPECIFIER_DECLARATION_LIST_SEMICOLON
        
        | ts=type_specifier sm=SEMICOLON
        {
            $type = $ts.type;
            $varDecStr = $ts.type + ";";
            bool errorDisplayType2 = false;
            logAndErrorType2(_input->LT(-1)->getLine(), "var_declaration : type_specifier declaration_list SEMICOLON", "syntax error, unexpected SEMICOLON, expecting declaration_list",
                $varDecStr);
        } #VARDEC_TYPE_SPECIFIER_SEMICOLON 

        | STRUCT struct_type_name=ID dl=declaration_list sm=SEMICOLON
        {
            $varDecStr = "struct " + $struct_type_name.text + " " + $dl.varList.get_list_as_string() + ";";
            // $type = "struct " + $ID.text;
            currentType = $type;
            logSSA(_input->LT(-1)->getLine(), "type_specifier : STRUCT ID declaration_list SEMICOLON",
                     $varDecStr);
        } #VARDEC_STRUCT_ID_DECLARATION_LIST_SEMICOLON

        | ts=type_specifier ID ASSIGNOP logicExpr=logic_expression SEMICOLON
        {
            $type = $ts.type;
            $varDecStr = $ts.type + " " + $ID->getText() + " = " + $logicExpr.logicExprStr + ";";
            bool errorDisplayType2 = false;

            if($ts.type == "void")
            {
                // logError(_input->LT(-1)->getLine(), "Variable type cannot be void");
                errorDisplayType2 = true;
                semanticErrorCount++;
            }

            if(!symbolTable->insert($ID->getText(), "ID"))
            {
                logError(_input->LT(-1)->getLine(), "Multiple declaration of " + $ID->getText());
                semanticErrorCount++;
            }
            else
            {
                SymbolInfo* var = symbolTable->lookUp($ID->getText());
                if(var)
                {
                    var->interpretedType = $type;
                    // cout << "$$$$$$$$$ Type: " << $type << endl;
                    // cout << "######################Var type updated?? " << var->getSymbolName() << " " << var->interpretedType << endl;
                }
            }

            if(errorDisplayType2 == false)
            {
                logSSA(_input->LT(-1)->getLine(), "var_declaration : type_specifier ID ASSIGNOP logic_expression SEMICOLON", 
                    $varDecStr);
            }
            else
            {    
                logAndErrorType2(_input->LT(-1)->getLine(), "var_declaration : type_specifier ID ASSIGNOP logic_expression SEMICOLON", "Variable type cannot be void",
                    $varDecStr);
            }
        } #VARDEC_TYPE_SPECIFIER_ID_ASSIGNOP_LOGIC_EXPRESSION_SEMICOLON
;

var_declaration_list returns [string varDecListStr]: 
        vd=var_declaration
        {
            $varDecListStr = $vd.varDecStr;
            logSSA(_input->LT(-1)->getLine(), "var_declaration_list : var_declaration", $varDecListStr);
        } #VARDECLIST_VARDEC
        | vdl=var_declaration_list varDec=var_declaration
        {
            $varDecListStr = $vdl.varDecListStr + "\n" + $varDec.varDecStr;
            logSSA(_input->LT(-1)->getLine(), "var_declaration_list : var_declaration_list var_declaration", $varDecListStr);
        } #VARDECLIST_VARDECLIST_VARDEC
;

struct_declaration returns [std::string structDeclarationStr]: 
        STRUCT ID LCURL vdl=var_declaration_list RCURL SEMICOLON
        {
            $structDeclarationStr = "struct " + $ID->getText() + " {\n" + $vdl.varDecListStr + "\n};";
            logSSA(_input->LT(-1)->getLine(), "struct_declaration : STRUCT ID LCURL var_declaration_list RCURL SEMICOLON", $structDeclarationStr);
        }

        
;

declaration_list_err returns [std::string error_name]: {
        $error_name = "Error in declaration list";
};


type_specifier returns [std::string name_line, std::string type]	
        : INT {
            $name_line = "type: INT at line" + std::to_string($INT->getLine());
            $type = "int";
            currentType = $type;

            logSSA($INT->getLine(), "type_specifier : INT",
                     "int");
        } #TYPE_SPECIFIER_INT
 		| FLOAT {
            $name_line = "type: FLOAT at line" + std::to_string($FLOAT->getLine());
            $type = "float";
            currentType = $type;
            logSSA($FLOAT->getLine(), "type_specifier : FLOAT",
                     "float");
        } #TYPE_SPECIFIER_FLOAT
 		| VOID {
            $name_line = "type: VOID at line" + std::to_string($VOID->getLine());
            $type = "void";
            currentType = $type;
            logSSA($VOID->getLine(), "type_specifier : VOID",
                     "void");
        } #TYPE_SPECIFIER_VOID
        // | STRUCT struct_type_name=ID
        // {
        //     $name_line = "type: STRUCT at line" + _input->LT(-1)->getLine();
        //     $type = "struct " + $ID.text;
        //     currentType = $type;
        //     logSSA($ID->getLine(), "type_specifier : STRUCT ID",
        //              "struct " + $ID.text);
        // }
;
 		
declaration_list returns [str_list varList, str_list retList]: 
            dl=declaration_list COMMA ID
            {
                $varList.set_variables($dl.varList.get_variables());
                $varList.add($ID->getText());

                $retList.set_variables($dl.retList.get_variables());

                if (!symbolTable->insert($ID->getText(), "ID")) {
                    logError(_input->LT(-1)->getLine(), "Multiple declaration of " + $ID->getText());
                    semanticErrorCount++;
                }
                else {
                    SymbolInfo* var = symbolTable->lookUp($ID->getText());
                    // if(var) var->interpretedType = currentType;
                    $retList.add($ID->getText());
                }

                logSSA($ID->getLine(), "declaration_list : declaration_list COMMA ID", $varList.get_list_as_string());
            } #DECLIST_DECLIST_COMMA_ID
            | dl=declaration_list COMMA ID LTHIRD CONST_INT RTHIRD
            {
                $varList.set_variables($dl.varList.get_variables());
                $varList.add($ID->getText() + "[" + $CONST_INT->getText() + "]");
                cout << "Current type: " << currentType << endl;
                $retList.set_variables($dl.retList.get_variables());

                // currentType += " array";

                if(!symbolTable->insert($ID->getText(), "ID")) {
                    logError(_input->LT(-1)->getLine(), "Multiple declaration of " + $ID->getText());
                    semanticErrorCount++;
                }
                else
                {
                    SymbolInfo* var = symbolTable->lookUp($ID->getText());
                    if(var)
                    {
                        var->makeArraySymbol(currentType, stoi($CONST_INT->getText()));
                        // var->interpretedType = currentType;
                        $retList.add($ID->getText());
                    }
                }
                logSSA($ID->getLine(), "declaration_list : declaration_list COMMA ID LTHIRD CONST_INT RTHIRD", $varList.get_list_as_string());
            } #DECLIST_DECLIST_COMMA_ID_LTHIRD_CONST_INT_RTHIRD
            | ID 
            {
                $varList.add($ID->getText());

                if (!symbolTable->insert($ID->getText(), "ID")) {
                    logError(_input->LT(-1)->getLine(), "Multiple declaration of " + $ID->getText());
                    semanticErrorCount++;
                }
                else
                {
                    // SymbolInfo* var = symbolTable->lookUp($ID->getText());
                    cout << "Current type: " << currentType << endl;
                    // if(var) var->interpretedType = currentType;
                    $retList.add($ID->getText());
                }
                logSSA($ID->getLine(), "declaration_list : ID", $ID->getText()); 
            } #DECLIST_ID
            | ID LTHIRD CONST_INT RTHIRD
            {
                $varList.add($ID->getText() + "[" + $CONST_INT->getText() + "]");

                // currentType += " array";

                if(!symbolTable->insert($ID->getText(), "ID")) {
                    logError(_input->LT(-1)->getLine(), "Multiple declaration of " + $ID->getText());
                    semanticErrorCount++;
                }
                else
                {
                    SymbolInfo* var = symbolTable->lookUp($ID->getText());
                    if(var)
                    {
                        var->makeArraySymbol(currentType, stoi($CONST_INT->getText()));
                        $retList.add($ID->getText());
                    }
                }
                logSSA($ID->getLine(), "declaration_list : ID LTHIRD CONST_INT RTHIRD", $ID->getText() + "[" + $CONST_INT->getText() + "]");
            } #DECLIST_ID_LTHIRD_CONST_INT_RTHIRD
            | dl=declaration_list ADDOP ID
            {
                logError(_input->LT(-1)->getLine(), "syntax error, unexpected ADDOP, expecting COMMA or SEMICOLON");
                syntaxErrorCount++;

                $varList.set_variables($dl.varList.get_variables());
                $retList.set_variables($dl.retList.get_variables());

                // $varList.set_variables({});
                // $retList.set_variables({});
            } #DECLIST_error // shouldn't happen for icg offline
;
 		  
statements returns [std::string multiStmtStr]:
        singleStatement=statement
        {
            $multiStmtStr = $singleStatement.stmtStr;
            if($multiStmtStr!="")
                logSSA(_input->LT(-1)->getLine(), "statements : statement", $multiStmtStr);
        } #STATEMENTS_SINGLE_STATEMENT
        | multiStmt=statements singleStmt=statement
        {
            $multiStmtStr = $multiStmt.multiStmtStr;
            if($singleStmt.stmtStr != "") 
                $multiStmtStr += "\n" + $singleStmt.stmtStr;
            else
                $multiStmtStr += $singleStmt.stmtStr;

            if($multiStmtStr != "" && $singleStmt.stmtStr != "")
                logSSA(_input->LT(-1)->getLine(), "statements : statements statement", $multiStmtStr);
            
        } #STATEMENTS_MULTI_STATEMENT_SINGLE_STATEMENT
;

switch_case returns [string switchStr]:
    SWITCH LPAREN expression RPAREN
    LCURL
    swtchStmt=switch_statement 
    defaultCaseStmt=default_case_statement
    RCURL
    {
        logSSA(_input->LT(-1)->getLine(), "switch_case: switch (expression) { switch_statement default_case_statement }", $ctx->getText());
    }
    
;

do_while returns [string doWhileStr]:
    DO
    {
        insideLoop = true;
        loopNestingLevel++;
    }
    compStmt=compound_statement
    WHILE LPAREN expr=expression RPAREN 
    SEMICOLON
    {
        insideLoop = false;
        loopNestingLevel--;
        if(loopNestingLevel < 0)
        {
            loopNestingLevel = 0;
        }
        $doWhileStr = "do " + $compStmt.compoundStmtStr + " while (" + $expr.exprStr + ");";
    }
    
;

statement returns [std::string stmtStr, string label, string ifLabel, string elseLabel]
        :
        varDec=var_declaration
        {
            $stmtStr = $varDec.varDecStr;
            logSSA(_input->LT(-1)->getLine(), "statement : var_declaration", $stmtStr);
        } #STATEMENT_VAR_DEC
        | exprStmt=expression_statement
        {
            $stmtStr = $exprStmt.exprStmtStr;
            if($exprStmt.exprStmtStr != "")
                logSSA(_input->LT(-1)->getLine(), "statement : expression_statement", $stmtStr);
        } #STATEMENT_EXPRSTMT
        | compStmt=compound_statement
        {
            $stmtStr = $compStmt.compoundStmtStr;
            logSSA(_input->LT(-1)->getLine(), "statement : compound_statement", $stmtStr);
        } #STATEMENT_COMPOUND_STATEMENT
        | FOR LPAREN exprStmt1=expression_statement exprStmt2=expression_statement expr=expression RPAREN 
        {
            insideLoop = true;
            loopNestingLevel++;
        }
        stmt=statement
        {
            insideLoop = false;
            loopNestingLevel--;
            cout << "#######Loop nesting level: " << loopNestingLevel << endl;
            if(loopNestingLevel < 0)
            {
                loopNestingLevel = 0;
            }
            $stmtStr = $FOR->getText() + $LPAREN->getText() + $exprStmt1.exprStmtStr + $exprStmt2.exprStmtStr + $expr.exprStr + $RPAREN->getText() + $stmt.stmtStr;
            logSSA(_input->LT(-1)->getLine(), "statement : FOR LPAREN expression_statement expression_statement expression RPAREN statement", $stmtStr);
        } #STATEMENT_FOR
        | IF LPAREN expr=expression RPAREN stmt=statement
        {
            $stmtStr = $IF->getText() + $LPAREN->getText() + $expr.exprStr + $RPAREN->getText() + $stmt.stmtStr;
            logSSA(_input->LT(-1)->getLine(), "statement : IF LPAREN expression RPAREN statement", $stmtStr);
        } #STATEMENT_IF
        | IF LPAREN expr=expression RPAREN stmt1=statement ELSE stmt2=statement
        {
            $stmtStr = $IF->getText() + $LPAREN->getText() + $expr.exprStr + $RPAREN->getText() + $stmt1.stmtStr + $ELSE->getText() + " " + $stmt2.stmtStr;
            logSSA(_input->LT(-1)->getLine(), "statement : IF LPAREN expression RPAREN statement ELSE statement", $stmtStr);
        } #STATEMENT_IF_ELSE
        | WHILE
        {
            insideLoop = true;
            loopNestingLevel++;
        }
        LPAREN expr=expression RPAREN stmt=statement
        {
            insideLoop = false;
            loopNestingLevel--;
            cout << "#####Loop nesting level: " << loopNestingLevel << endl;
            if(loopNestingLevel < 0)
            {
                loopNestingLevel = 0;
            }
            $stmtStr = $WHILE->getText() + $LPAREN->getText() + $expr.exprStr + $RPAREN->getText() + $stmt.stmtStr;
            logSSA(_input->LT(-1)->getLine(), "statement : WHILE LPAREN expression RPAREN statement", $stmtStr);
        } #STATEMENT_WHILE
        
        | PRINTF LPAREN ID RPAREN SEMICOLON
        {
            $stmtStr = $PRINTF->getText() + " " + $LPAREN->getText() + $ID->getText() + $RPAREN->getText() + ";";
            logSSA(_input->LT(-1)->getLine(), "statement : PRINTLN LPAREN ID RPAREN SEMICOLON", $stmtStr);

        } #STATEMENT_PRINTLN
        | RETURN expr=expression SEMICOLON
        {
            $stmtStr = $RETURN->getText() + " " + $expr.exprStr + ";";
            string currRetType = retTypeStack.top();

            // if(funcRetType != "void" && funcRetType != $expr.type)
            if(currRetType != "void" && currRetType != $expr.type)
            {
                logError(_input->LT(-1)->getLine(), "Return type mismatch of " + currentFunction);
                semanticErrorCount++;
            }
            if (funcRetType == "void")
            {
                // logError(_input->LT(-1)->getLine(), "Cannot return value from function " + currentFunction + " with void return type");
                // semanticErrorCount++;
            }
            logSSA(_input->LT(-1)->getLine(), "statement : RETURN expression SEMICOLON", $stmtStr);
        } #STATEMENT_RETURN
        | switch_case {logSSA(_input->LT(-1)->getLine(), "switch_case" , $ctx->getText()) ;} #STATEMENT_SWITCH_CASE
        | BREAK SEMICOLON
        {
            $stmtStr = $BREAK->getText() + ";";
            logSSA(_input->LT(-1)->getLine(), "statement: BREAK SEMICOLON", $stmtStr);
            
            // does not work for nested loops
            // if(insideLoop == false)
            //     logError(_input->LT(-1)->getLine(), "break outside loop or switch statement");

            if(loopNestingLevel == 0)
            {
                logError(_input->LT(-1)->getLine(), "break outside loop or switch statement");
                semanticErrorCount++;
            }


        } #STATEMENT_BREAK
        | CONTINUE SEMICOLON
        {
            $stmtStr = $CONTINUE->getText() + ";";
            logSSA(_input->LT(-1)->getLine(), "statement: CONTINUE SEMICOLON", $stmtStr);
            
            // does not work for nested loops
            // if(insideLoop == false)
            //     logError(_input->LT(-1)->getLine(), "continue outside loop");

            if(loopNestingLevel == 0)
            {
                logError(_input->LT(-1)->getLine(), "continue outside loop");
                semanticErrorCount++;
            }
        } #STATEMENT_CONTINUE
        | dw=do_while
        {
            $stmtStr = $dw.doWhileStr;
            logSSA(_input->LT(-1)->getLine(), "statement: do_while" , $dw.doWhileStr) ;
        } #STATEMENT_DO_WHILE
        /*
        | PRINTF LPAREN ID RPAREN SEMICOLON
        {
            $stmtStr = $PRINTF->getText() + $LPAREN->getText() + $ID->getText() + $RPAREN->getText() + ";";
            // logSSA(_input->LT(-1)->getLine(), "statement : PRINTF LPAREN ID RPAREN SEMICOLON", $stmtStr);
            SymbolInfo* temp = symbolTable->lookUp($ID->getText());
            bool errorDisplayType2 = false;
            if(temp)
            {
                if(temp->isFunction && !temp->definedFunction)
                {
                    logError(_input->LT(-1)->getLine(), "Cannot use function " + $ID->getText() + " in expression before definition");
                    semanticErrorCount++;
                }

                if(temp->interpretedType == "void")
                {
                    logError(_input->LT(-1)->getLine(), "Void function used in printf statement: " + $ID->getText());
                    semanticErrorCount++;
                }
            }
            else
            {
                // logError(_input->LT(-1)->getLine(), "Undeclared variable " + $ID->getText());
                logAndErrorType2(_input->LT(-1)->getLine(), "statement : PRINTLN LPAREN ID RPAREN SEMICOLON", "Undeclared variable " + $ID->getText(), $stmtStr);
                errorDisplayType2 = true;
                semanticErrorCount++;
            }

            if(errorDisplayType2 == false)
                logSSA(_input->LT(-1)->getLine(), "statement : PRINTLN LPAREN ID RPAREN SEMICOLON", $stmtStr);
        } #STATEMENT_PRINTF
        */
;

const_new returns [string constStr]:
    CONST_INT { $constStr = $CONST_INT->getText(); logSSA(_input->LT(-1)->getLine(), "const_new : CONST_INT", $constStr); }
    #CONSTNEW_CONST_INT
    | CONST_FLOAT { $constStr = $CONST_FLOAT->getText(); logSSA(_input->LT(-1)->getLine(), "const_new : CONST_FLOAT", $constStr); }
    #CONSTNEW_CONST_FLOAT
;



switch_statement returns [string stmrStr]:
    caseStmt=case_statement
    {
        logSSA(_input->LT(-1)->getLine(), "switch_statement: case_statement", $caseStmt.stmtStr);
    } #SWITCHSTATEMENT_CASE_STATEMENT
    | case_statement switch_statement
    {
        logSSA(_input->LT(-1)->getLine(), "switch_statement: case_statement switch_statement", $ctx->getText());
    } #SWITCHSTATEMENT_CASE_STATEMENT_SWITCHSTATEMENT
;

case_statement returns [string stmtStr]:
    CASE const=const_new colon=COLON multiStmt=statements BREAK SEMICOLON
    {
        // $stmtStr = $const.constStr + " " + $colon->getText() + " " + $multiStmt.multiStmtStr + $BREAK->getText() + ";";
        logSSA(_input->LT(-1)->getLine(), "case_statement: CASE CONST COLON statements BREAK SEMICOLON", $stmtStr);
    }
;

default_case_statement returns [string stmtStr]:
    DEFAULT COLON statements BREAK SEMICOLON
    {
        logSSA(_input->LT(-1)->getLine(), "default_statement", $ctx->getText());
    }
    |
;

expression_statement returns [std::string exprStmtStr]: 
            SEMICOLON	
            {
                $exprStmtStr = $SEMICOLON->getText();
                logSSA(_input->LT(-1)->getLine(), "expression_statement : SEMICOLON", $exprStmtStr);
            } #EXPRSTMT_SEMICOLON
			| expr=expression SEMICOLON 
            {
                if($expr.exprStr != "")
                {
                    $exprStmtStr = $expr.exprStr + ";";
                    logSSA(_input->LT(-1)->getLine(), "expression_statement : expression SEMICOLON", $exprStmtStr);
                }
                else
                {
                    $exprStmtStr = $expr.exprStr;
                }
            } #EXPRSTMT_EXPRESSION_SEMICOLON
;
	  

variable returns [std::string varExpr, string type, string varName]:
        ID 	
        {
            $varExpr = $ID->getText();
            $varName = $ID->getText();

            SymbolInfo* var = symbolTable->lookUp($ID->getText());
            bool errorDisplayType2 = false;
            if(var)
            {
                $type = var->interpretedType;
                cout << "Line (INSIDE VARIABLE: ID ): " << _input->LT(-1)->getLine() << " variable "<< $varExpr << " type: " << $type << endl;
                if(var->isArray)
                { 
                    // logError(_input->LT(-1)->getLine(), "Type mismatch, " + $ID->getText() + " is an array"); 
                    logAndErrorType2(_input->LT(-1)->getLine(), "variable : ID", "Type mismatch, " + $ID->getText() + " is an array", $varExpr);
                    semanticErrorCount++; 
                    errorDisplayType2 = true;
                }

                else if (var->isFunction) { logError(_input->LT(-1)->getLine(), "Type mismatch, " + $ID->getText() + " is a function"); semanticErrorCount++;}
                // else if(funcRetType != $type && funcRetType != "void")
                // {
                //     logError(_input->LT(-1)->getLine(), "Return type mismatch of " + currentFunction);
                //     semanticErrorCount++;
                // }
            }
            else
            {
                // logError(_input->LT(-1)->getLine(), "Undeclared variable " + $ID->getText());
                logAndErrorType2(_input->LT(-1)->getLine(), "variable : ID", "Undeclared variable " + $ID->getText(), $varExpr);
                errorDisplayType2 = true;
                semanticErrorCount++;
                $type = "undeclared";
            }

            if(errorDisplayType2 == false)
            { logSSA(_input->LT(-1)->getLine(), "variable : ID", $varExpr); }
        } #VARIABLE_ID
        | ID LTHIRD expr=expression RTHIRD 
        {
            $varName = $ID->getText();
            $varExpr = $ID->getText() + "[" + $expr.exprStr + "]";

            SymbolInfo* var = symbolTable->lookUp($ID->getText());
            bool errorDisplayType2 = false;
            if(var)
            {
                cout << $ID->getText() << " " << var->isArray << " is the isArray value" << endl;
                if($expr.type != "int")
                {
                    // logError(_input->LT(-1)->getLine(), "Expression inside third brackets not an integer");
                    errorDisplayType2 = true;
                    logAndErrorType2(_input->LT(-1)->getLine(), "variable : ID LTHIRD expression RTHIRD", "Expression inside third brackets not an integer", $varExpr);
                    semanticErrorCount++;
                }
                $type = var->interpretedType;

                if(funcRetType != $type && funcRetType != "void")
                {
                    logError(_input->LT(-1)->getLine(), "Return type mismatch of " + currentFunction);
                    semanticErrorCount++;
                }

                if (var->isArray == false)
                {
                    // logError(_input->LT(-1)->getLine(), $ID->getText() + " not an array");
                    errorDisplayType2 = true;
                    logAndErrorType2(_input->LT(-1)->getLine(), "variable : ID LTHIRD expression RTHIRD", $ID->getText() + " not an array", $varExpr);
                    semanticErrorCount++;
                }
            }
            
            else
            {
                logError(_input->LT(-1)->getLine(), "Undeclared variable " + $ID->getText());
                semanticErrorCount++;
                $type = "undeclared";
            }

            if(!errorDisplayType2)
                logSSA(_input->LT(-1)->getLine(), "variable : ID LTHIRD expression RTHIRD", $varExpr);
            
        } #VARIABLE_ID_LTHIRD_EXPRESSION_RTHIRD
;
	 
expression returns [std::string exprStr, string type]:
        logicExpr=logic_expression    
        {
            $exprStr = $logicExpr.logicExprStr;
            $type = $logicExpr.type;
            logSSA(_input->LT(-1)->getLine(), "expression : logic_expression", $exprStr);
        } #EXPRESSION_LOGIC_EXPRESSION
        | var=variable ASSIGNOP logicExpr=logic_expression 
        {
            $exprStr = $var.varExpr + $ASSIGNOP->getText() + $logicExpr.logicExprStr;
            // NOTE
            // $var.type is useless here
            // $type = $var.type;
            SymbolInfo* varSymbol = symbolTable->lookUp($var.varName);
            bool varIsArray = false;
            bool errorDisplayType2 = false;

            if(varSymbol)
            {
                $type = varSymbol->interpretedType;
                if (varSymbol->isFunction) 
                {
                    logError(_input->LT(-1)->getLine(), "Type mismatch, " + $var.varExpr + " is a function");
                    semanticErrorCount++;
                }
                if (varSymbol->isArray) 
                {
                    varIsArray = true;
                }
            }
            else
            {
                cout << "NAIII" << endl;
                // logError(_input->LT(-1)->getLine(), "Undeclared variable " + $var.varExpr);
                // semanticErrorCount++;
                $type = "undeclared";
            }
            
            cout << "Line (INSIDE VARIABLE: ASSIGNOP): " << _input->LT(-1)->getLine() << " variable "<< $var.varExpr << " type: " << $type << " isArray: " << varIsArray << endl;
            cout << "Line :" << _input->LT(-1)->getLine() << " variable "<< $var.varExpr << " type: " << $type << endl;
            cout << "\t" << " logic expression "<< $logicExpr.logicExprStr << " type: " << $logicExpr.type << endl;

            // will function similar to xv6. 
            // currently INT = FLOAT is allowed in C, so is FLOAT = INT
            // but allowing that will cause mismatch with logs for assignment 3

            if($type != "undeclared" && $logicExpr.type != "undeclared" && $logicExpr.type != "undefined")
            {
                if($type != $logicExpr.type && $logicExpr.type != "void")
                {
                    // if(!(($type == "int" && (varIsArray == false) && $logicExpr.type == "float") 
                    //     || ($type == "float" && $logicExpr.type == "int")))
                    if(!( (varIsArray == false) && ($type == "float" && $logicExpr.type == "int")))
                    {
                        // logError(_input->LT(-1)->getLine(), "Type Mismatch");

                        logAndErrorType2(_input->LT(-1)->getLine(), "expression : variable ASSIGNOP logic_expression", "Type Mismatch", $exprStr);

                        errorDisplayType2 = true;
                        semanticErrorCount++;
                    }
                }

                if($logicExpr.type == "void")
                {
                    // logError(_input->LT(-1)->getLine(), "Void function used in expression");
                    logAndErrorType2(_input->LT(-1)->getLine(), "expression : variable ASSIGNOP logic_expression", "Void function used in expression", $exprStr);
                    errorDisplayType2 = true;
                    semanticErrorCount++;
                }
            }

            if($logicExpr.logicExprStr != "")
            {
                if(errorDisplayType2 == false) logSSA(_input->LT(-1)->getLine(), "expression : variable ASSIGNOP logic_expression", $exprStr);
            }
            else
                $exprStr = "";

        } #EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSION 
        | var=variable ASSIGNOP expr=expression
        {
            $exprStr = $var.varExpr + $ASSIGNOP->getText() + $expr.exprStr;
            // NOTE
            // $var.type is useless here
            // $type = $var.type;
            SymbolInfo* varSymbol = symbolTable->lookUp($var.varName);
            bool varIsArray = false;
            bool errorDisplayType2 = false;

            if(varSymbol)
            {
                $type = varSymbol->interpretedType;
                if (varSymbol->isFunction) 
                {
                    logError(_input->LT(-1)->getLine(), "Type mismatch, " + $var.varExpr + " is a function");
                    semanticErrorCount++;
                }
                if (varSymbol->isArray) 
                {
                    varIsArray = true;
                }
            }
            else
            {
                cout << "NAIII" << endl;
                // logError(_input->LT(-1)->getLine(), "Undeclared variable " + $var.varExpr);
                // semanticErrorCount++;
                $type = "undeclared";
            }
            
            cout << "Line (INSIDE VARIABLE: ASSIGNOP): " << _input->LT(-1)->getLine() << " variable "<< $var.varExpr << " type: " << $type << " isArray: " << varIsArray << endl;
            cout << "Line :" << _input->LT(-1)->getLine() << " variable "<< $var.varExpr << " type: " << $type << endl;
            cout << "\t" << " expression "<< $expr.exprStr << " type: " << $expr.type << endl;

            // will function similar to xv6. 
            // currently INT = FLOAT is allowed in C, so is FLOAT = INT

            if($type != "undeclared" && $expr.type != "undeclared" && $expr.type != "undefined")
            {
                if($type != $expr.type && $expr.type != "void")
                {
                    // if(!(($type == "int" && (varIsArray == false) && $expr.type == "float") 
                    //     || ($type == "float" && $expr.type == "int")))
                    if(!( (varIsArray == false) && ($type == "float" && $expr.type == "int")))
                    {   
                        // logError(_input->LT(-1)->getLine(), "Type Mismatch");
                        logAndErrorType2(_input->LT(-1)->getLine(), "expression : variable ASSIGNOP expression", "Type Mismatch", $exprStr);
                        errorDisplayType2 = true;
                        semanticErrorCount++;
                    }
                }
            }

            if($expr.type == "void")
            {
                // logError(_input->LT(-1)->getLine(), "Void function used in expression");
                logAndErrorType2(_input->LT(-1)->getLine(), "expression : variable ASSIGNOP expression", "Void function used in expression", $exprStr);
                errorDisplayType2 = true;
                semanticErrorCount++;
            }

            if($expr.exprStr != "")
            {
                if(errorDisplayType2 == false) logSSA(_input->LT(-1)->getLine(), "expression : variable ASSIGNOP expression", $exprStr);
            }
            else
            {
                $exprStr = "";
            }
        } #EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSION
        | expr=expression UNRECOGNIZED_CHAR
        {
            logError(_input->LT(-1)->getLine(), "Unrecognized character " + $UNRECOGNIZED_CHAR->getText());
            semanticErrorCount++;
            $exprStr = "";
            $type = "error";
        } #EXPRESSION_EXPRESSION_UNRECOGNIZED_CHAR // shouldn't happen for icg offline
;

logic_expression returns [std::string logicExprStr, string type, string funcNameIfFunction]: 
        relExpr=rel_expression
        {
            $logicExprStr = $relExpr.relExprStr;
            $type = $relExpr.type;
            $funcNameIfFunction = $relExpr.funcNameIfFunction;
            cout << "Line: " << _input->LT(-1)->getLine() << " " << $logicExprStr << " " << $relExpr.type << endl;\
            if($relExpr.relExprStr != "")
                logSSA(_input->LT(-1)->getLine(), "logic_expression : rel_expression", $logicExprStr);
        } #LOGICEXPRESSION_REL_EXPRESSION
        | relExpr1=rel_expression LOGICOP relExpr2=rel_expression
        {
            $logicExprStr = $relExpr1.relExprStr + $LOGICOP->getText() + $relExpr2.relExprStr;
            $type = "int"; // C doesn't technically have bool :3, don't change laterrrr
            if($relExpr1.funcNameIfFunction != "")
            {
                // $funcNameIfFunction = $relExpr1.funcNameIfFunction;
                SymbolInfo* func1 = symbolTable->lookUp($relExpr1.funcNameIfFunction);

                if(func1)
                {
                    if(func1->isFunction && !func1->definedFunction)
                    {
                        logError(_input->LT(-1)->getLine(), "Cannot use function " + $relExpr1.funcNameIfFunction + " in expression before definition");
                        semanticErrorCount++;
                    }

                    if(func1->interpretedType == "void")
                    {
                        logError(_input->LT(-1)->getLine(), "Void function used in expression");
                        semanticErrorCount++;
                    }
                }
            }
            if($relExpr2.funcNameIfFunction != "")
            {
                SymbolInfo* func2 = symbolTable->lookUp($relExpr2.funcNameIfFunction);
                if(func2)
                {
                    if(func2->isFunction && !func2->definedFunction)
                    {
                        logError(_input->LT(-1)->getLine(), "Cannot use function " + $relExpr2.funcNameIfFunction + " in expression before definition");
                        semanticErrorCount++;
                    }

                    if(func2->interpretedType == "void")
                    {
                        logError(_input->LT(-1)->getLine(), "Void function used in expression");
                        semanticErrorCount++;
                    }
                }
            }
            logSSA(_input->LT(-1)->getLine(), "logic_expression : rel_expression LOGICOP rel_expression", $logicExprStr);
        } #LOGICEXPRESSION_REL_EXPRESSION_LOGICOP_REL_EXPRESSION
;
			
rel_expression returns [std::string relExprStr, string type, string funcNameIfFunction]: 
        simpleExpr=simple_expression 
        {
            $relExprStr = $simpleExpr.simpleExprStr;
            if($simpleExpr.simpleExprStr != "")
            {
                logSSA(_input->LT(-1)->getLine(), "rel_expression : simple_expression", $relExprStr);
            }
            $type = $simpleExpr.type;
            $funcNameIfFunction = $simpleExpr.funcNameIfFunction;
        } #RELEXPRESSION_SIMPLE_EXPRESSION
		| simpleExpr1=simple_expression RELOP simpleExpr2=simple_expression
        {
            $relExprStr = $simpleExpr1.simpleExprStr + $RELOP->getText() + $simpleExpr2.simpleExprStr;
            $type = "int"; // C doesn't technically have bool :3, don't change laterrrr

            if($simpleExpr1.funcNameIfFunction != "")
            {
                $funcNameIfFunction = "FUNCTION"; // non empty only to check later on
                SymbolInfo* func1 = symbolTable->lookUp($simpleExpr1.funcNameIfFunction);

                if(func1)
                {
                    if(func1->isFunction && !func1->definedFunction)
                    {
                        logError(_input->LT(-1)->getLine(), "Cannot use function " + $simpleExpr1.funcNameIfFunction + " in expression before definition");
                        semanticErrorCount++;
                    }

                    if(func1->interpretedType == "void")
                    {
                        logError(_input->LT(-1)->getLine(), "Void function used in expression");
                        semanticErrorCount++;
                    }
                }
            }
            if($simpleExpr2.funcNameIfFunction != "")
            {
                SymbolInfo* func2 = symbolTable->lookUp($simpleExpr2.funcNameIfFunction);
                $funcNameIfFunction = "FUNCTION"; // non empty only to check later on
                if(func2)
                {
                    if(func2->isFunction && !func2->definedFunction)
                    {
                        logError(_input->LT(-1)->getLine(), "Cannot use function " + $simpleExpr2.funcNameIfFunction + " in expression before definition");
                        semanticErrorCount++;
                    }

                    if(func2->interpretedType == "void")
                    {
                        logError(_input->LT(-1)->getLine(), "Void function used in expression");
                        semanticErrorCount++;
                    }
                }
            }

                

            logSSA(_input->LT(-1)->getLine(), "rel_expression : simple_expression RELOP simple_expression", $relExprStr);
        } #RELEXPRESSION_SIMPLE_EXPRESSION_RELOP_SIMPLE_EXPRESSION
;

simple_expression returns [std::string simpleExprStr, string type, string funcNameIfFunction]: 
        t=term 
        {
            $simpleExprStr = $t.termStr;
            
            $type = $t.type;
            $funcNameIfFunction = $t.funcNameIfFunction;
            logSSA(_input->LT(-1)->getLine(), "simple_expression : term", $simpleExprStr);
        } #SIMPLEEXPRESSION_TERM
        | simpleExpr=simple_expression ADDOP t=term 
        {
            cout << "SIMPLEEXPR ADDOP TERM... TERMSTR " << $t.termStr << "T_T" << endl;
            if($t.termStr != "")
            {   $simpleExprStr = $simpleExpr.simpleExprStr + $ADDOP->getText() + $t.termStr;
                logSSA(_input->LT(-1)->getLine(), "simple_expression : simple_expression ADDOP term", $simpleExprStr);
            }
            else
            {
                $simpleExprStr = "";
            }
            $funcNameIfFunction = $t.funcNameIfFunction;
            if($simpleExpr.type == "float" || $t.type == "float")
            {
                $type = "float";
            }
            else { $type = "int"; }

        } #SIMPLEEXPRESSION_SIMPLE_EXPRESSION_ADDOP_TERM
;
					
term returns [std::string termStr, string type, string funcNameIfFunction]:	
        unaryExpr=unary_expression
        {
            $termStr = $unaryExpr.unaryExprStr;
            $type = $unaryExpr.type;
            logSSA(_input->LT(-1)->getLine(), "term : unary_expression", $termStr);
        } #TERM_UNARY_EXPRESSION
        |  t=term MULOP unaryExpr=unary_expression
        {
            $termStr = $t.termStr + $MULOP->getText() + $unaryExpr.unaryExprStr;
            $type = $unaryExpr.type;
            bool errorDisplayType2 = false;

            if($MULOP->getText() == "%")
            {
                $type = "int";
                if($unaryExpr.type != "int" || $t.type != "int")
                {                        
                    // logError(_input->LT(-1)->getLine(), "Non-Integer operand on modulus operator");
                    errorDisplayType2 = true;
                    logAndErrorType2(_input->LT(-1)->getLine(), "term : term MULOP unary_expression", "Non-Integer operand on modulus operator" , $termStr);
                    semanticErrorCount++;
                }

                if($unaryExpr.text == "0")
                {
                    // logError(_input->LT(-1)->getLine(), "Modulus by Zero");
                    errorDisplayType2 = true;
                    logAndErrorType2(_input->LT(-1)->getLine(), "term : term MULOP unary_expression", "Modulus by Zero", $termStr);
                    semanticErrorCount++;
                }
            }
            else if($MULOP->getText() == "/")
            {
                if($unaryExpr.type != "int" && $unaryExpr.type != "float")
                {
                    logError(_input->LT(-1)->getLine(), "Non-numeric operand on division operator");
                    semanticErrorCount++;
                }

                if($t.type != "int" && $t.type != "float")
                {
                    logError(_input->LT(-1)->getLine(), "Non-numeric operand on division operator");
                    semanticErrorCount++;
                }

                if($unaryExpr.text == "0")
                {
                    logError(_input->LT(-1)->getLine(), "Division by zero");
                    semanticErrorCount++;
                }
            }

            if($unaryExpr.funcNameIfFunction != "")
            {
                $funcNameIfFunction = $unaryExpr.funcNameIfFunction;
                SymbolInfo* func = symbolTable->lookUp($unaryExpr.funcNameIfFunction);
                if(func)
                {
                    if(func->isFunction && !func->definedFunction)
                    {
                        logError(_input->LT(-1)->getLine(), "Cannot use function " + $unaryExpr.funcNameIfFunction + " in expression before definition");
                        semanticErrorCount++;
                    }

                    if(func->interpretedType == "void")
                    {
                        // logError(_input->LT(-1)->getLine(), "Void function used in expression");
                        errorDisplayType2 = true;
                        logAndErrorType2(_input->LT(-1)->getLine(), "term : term MULOP unary_expression", "Void function used in expression", $termStr);
                        semanticErrorCount++;
                    }

                }
            }
            
            if(errorDisplayType2 == false)
                logSSA(_input->LT(-1)->getLine(), "term : term MULOP unary_expression", $termStr);
        } #TERM_TERM_MULOP_UNARY_EXPRESSION
        | ASSIGNOP
        {
            logError(_input->LT(-1)->getLine(), "syntax error, unexpected ASSIGNOP");
            syntaxErrorCount++;

            $termStr = "";
            $type = "";
            $funcNameIfFunction = "";
        } #TERM_ASSIGNOP // shouldn't happen for icg offline
;

unary_expression returns [std::string unaryExprStr, string type, string funcNameIfFunction]:
        ADDOP unaryExpr=unary_expression  
        {
            $unaryExprStr = $ADDOP->getText() + $unaryExpr.unaryExprStr;
            $type = $unaryExpr.type;

            logSSA(_input->LT(-1)->getLine(), "unary_expression : ADDOP unary_expression", $unaryExprStr);
        } #UNARYEXPRESSION_ADDOP_UNARY_EXPRESSION
        | NOT unaryExpr=unary_expression 
        {
            $unaryExprStr = $NOT->getText() + $unaryExpr.unaryExprStr;
            if($unaryExpr.type != "int") // C doesn't technically have bool :3, don't change laterr
            {
                logError(_input->LT(-1)->getLine(), "Non-Boolean operand on NOT operator");
                semanticErrorCount++;
            }
            $type = "int"; // C doesn't technically have bool :3, don't change laterr
            logSSA(_input->LT(-1)->getLine(), "unary_expression : NOT unary_expression", $unaryExprStr);
        } #UNARYEXPRESSION_NOT_UNARY_EXPRESSION
        | fctr=factor 
        {
            $unaryExprStr = $fctr.factorStr;
            $type = $fctr.type;
            $funcNameIfFunction = $fctr.funcNameIfFunction;
            cout << "Line :" << _input->LT(-1)->getLine() << " type of factor " << $unaryExprStr << " " << $fctr.type << endl;
            logSSA(_input->LT(-1)->getLine(), "unary_expression : factor", $unaryExprStr);
        } #UNARYEXPRESSION_FACTOR
;
	
factor	returns [std::string factorStr, string type, string funcNameIfFunction]: 
        var=variable 
        {
            $factorStr = $var.varExpr;
            
            SymbolInfo* varInfo = symbolTable->lookUp($var.varName);
            if(varInfo)
            {
                $type = varInfo->interpretedType;
                if (varInfo->isArray) {
                    // logError(_input->LT(-1)->getLine(), "Type mismatch, " + $var.varExpr + " is an array");
                    // semanticErrorCount++;
                }
                else if (varInfo->isFunction) {
                    logError(_input->LT(-1)->getLine(), "Type mismatch, " + $var.varExpr + " is a function");
                    semanticErrorCount++;
                }
            }
            else
            {
                logError(_input->LT(-1)->getLine(), "Undeclared variable " + $var.varExpr);
                semanticErrorCount++;
                $type = "undeclared";
            }

            cout << "LINE :" << _input->LT(-1)->getLine() << " type of variable: " << $var.type << endl;
            logSSA(_input->LT(-1)->getLine(), "factor : variable", $factorStr);
        } #FACTOR_VARIABLE
        | ID LPAREN args=argument_list RPAREN
        {
            $factorStr = $ID->getText() + $LPAREN->getText() + $args.argListStr + $RPAREN->getText();
            $funcNameIfFunction = $ID->getText();
            bool errorDisplayType2 = false;

            SymbolInfo* func = symbolTable->lookUp($ID->getText());
            if(!func || !func->isFunction)
            {
                // logError(_input->LT(-1)->getLine(), "Undefined function " + $ID->getText());
                errorDisplayType2 = true;
                logAndErrorType2(_input->LT(-1)->getLine(), "factor : ID LPAREN argument_list RPAREN", "Undefined function " + $ID->getText(), $factorStr);
                semanticErrorCount++;
                $type = "undefined";
            }
            else
            {
                $type = func->interpretedType;

                vector<string> paramTypes;
                vector<string> argumentTypes = $args.typeList.get_variables();

                for (auto& param : func->parameters) {
                    paramTypes.push_back(param_type(param));
                }
                

                if(paramTypes.size() != argumentTypes.size())
                {
                    // logError(_input->LT(-1)->getLine(), "Total number of arguments mismatch with declaration in function " + $ID->getText());
                    errorDisplayType2 = true;
                    logAndErrorType2(_input->LT(-1)->getLine(), "factor : ID LPAREN argument_list RPAREN", "Total number of arguments mismatch with declaration in function " + $ID->getText(), $factorStr);
                    semanticErrorCount++;
                }
                else
                {
                    for (size_t i = 0; i < paramTypes.size(); ++i) {
                        if (paramTypes[i] != argumentTypes[i]
                            // && !(paramTypes[i] == "int" && argumentTypes[i] == "float")
                            && !(paramTypes[i] == "float" && argumentTypes[i] == "int")) {
                            // cout << "Param type: " << paramTypes[i] << " Argument type: " << argumentTypes[i] << endl;
                            // logError(_input->LT(-1)->getLine(), to_string(i+1) + "th argument mismatch in function " + $ID->getText());
                            errorDisplayType2 = true;
                            logAndErrorType2(_input->LT(-1)->getLine(), "factor : ID LPAREN argument_list RPAREN", to_string(i+1) + "th argument mismatch in function " + $ID->getText(), $factorStr);
                            semanticErrorCount++;
                            break;
                        }
                    }
                }
            }

            if(errorDisplayType2 == false)
                logSSA(_input->LT(-1)->getLine(), "factor : ID LPAREN argument_list RPAREN", $factorStr);
        } #FACTOR_FUNCTION_CALL
        | LPAREN expr=expression RPAREN
        {
            $factorStr = $LPAREN->getText() + $expr.exprStr + $RPAREN->getText();
            $type = $expr.type; 
            logSSA(_input->LT(-1)->getLine(), "factor : LPAREN expression RPAREN", $factorStr);
        } #FACTOR_EXPRESSION
        | CONST_INT 
        {
            $factorStr = $CONST_INT->getText();
            $type = "int";
            logSSA(_input->LT(-1)->getLine(), "factor : CONST_INT", $factorStr);
        } #FACTOR_CONST_INT
        | CONST_FLOAT
        {
            $factorStr = $CONST_FLOAT->getText();
            $type = "float";
            logSSA(_input->LT(-1)->getLine(), "factor : CONST_FLOAT", $factorStr);
        } #FACTOR_CONST_FLOAT
        | var=variable INCOP 
        {
            $factorStr = $var.varExpr + $INCOP->getText();
            SymbolInfo* varInfo = symbolTable->lookUp($var.varName);
            if(varInfo)
            {
                if (varInfo->isFunction) {
                    logError(_input->LT(-1)->getLine(), "Type mismatch, " + $var.varExpr + " is a function");
                    semanticErrorCount++;
                }

                $type = varInfo->interpretedType;

            }
            else
            {
                logError(_input->LT(-1)->getLine(), "Undeclared variable " + $var.varExpr);
                semanticErrorCount++;
                $type = "undeclared";
            }

            logSSA(_input->LT(-1)->getLine(), "factor : variable INCOP", $factorStr);
        } #FACTOR_VARIABLE_INC
        | var=variable DECOP
        {
            $factorStr = $var.varExpr + $DECOP->getText();
            SymbolInfo* varInfo = symbolTable->lookUp($var.varName);
            if(varInfo)
            {
                if (varInfo->isFunction) {
                    logError(_input->LT(-1)->getLine(), "Type mismatch, " + $var.varExpr + " is a function");
                    semanticErrorCount++;
                }

                $type = varInfo->interpretedType;

            }
            else
            {
                logError(_input->LT(-1)->getLine(), "Undeclared variable " + $var.varExpr);
                semanticErrorCount++;
                $type = "undeclared";
            }

            logSSA(_input->LT(-1)->getLine(), "factor : variable DECOP", $factorStr);
        } #FACTOR_VARIABLE_DEC
;
        
argument_list returns [string argListStr, str_list argList, str_list typeList]: 
            arguments
            {
                $argListStr = $arguments.argStr;
                $argList.set_variables($arguments.argList.get_variables());
                $typeList.set_variables($arguments.typeList.get_variables());
                for(int i = 0; i < $typeList.get_variables().size(); i++)
                {
                    cout << $typeList.get_variables()[i] << " ";
                }
                cout << endl;

                logSSA(_input->LT(-1)->getLine(), "argument_list : arguments", $argListStr);
            }
            |
;

arguments returns [string argStr, str_list argList, str_list typeList]: 
            args=arguments COMMA logicExpr=logic_expression
            {
                $argStr = $args.argStr + "," + $logicExpr.logicExprStr;
                cout << $argStr << endl;

                $argList.set_variables($args.argList.get_variables());
                $argList.add($logicExpr.logicExprStr);

                $typeList.set_variables($args.typeList.get_variables());
                $typeList.add($logicExpr.type);

                logSSA(_input->LT(-1)->getLine(), "arguments : arguments COMMA logic_expression", $argStr);
            } #ARGUMENTS_ARGUMENTS_COMMA_LOGIC_EXPRESSION
            | logicExpr=logic_expression
            {
                $argStr = $logicExpr.logicExprStr;

                $argList.set_variables({$logicExpr.logicExprStr});
                $typeList.set_variables({});
                $typeList.add($logicExpr.type);

                logSSA(_input->LT(-1)->getLine(), "arguments : logic_expression", $argStr);
            } #ARGUMENTS_LOGIC_EXPRESSION
;
