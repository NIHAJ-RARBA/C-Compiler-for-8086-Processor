#ifndef ICG_2105055_HPP
#define ICG_2105055_HPP
// #include<bits/stdc++.h>
#include "C2105055ParserBaseVisitor.h"

#include "headers/SymbolTable.hpp"
#include "headers/SymbolInfo.hpp"

using namespace std;

class ASMGenerator : public C2105055ParserBaseVisitor
{
private:

    SymbolTable* symbolTable;
    string printLibStr;
    bool printLibStrLoaded = false;
    bool insideNewScope = false;
    
    bool globalScope = true; 
    string currentFuncReturnLabel = "";
    int labelCount = 0;
    int paramOffset = 0;

    void asmStart()
    {

        if (!asmFile)
        {
            std::cout << "Error opening asmFile.txt" << std::endl;
            return;
        }
        if (!tempFile)
        {
            std::cout << "Error opening tempFile" << std::endl;
            return;
        }

        asmFile << ".MODEL SMALL\n"
                << ".STACK 1000H\n"
                << ".Data\n"
                << "\tnumber DB \"00000$\"\n"
                << endl;

        asmFile.flush();
    }

    void asmEnd()
    {
        if (!asmFile)
        {
            std::cout << "Error opening asmFile.txt" << std::endl;
            return;
        }

        if (printLibStrLoaded)
        {
            asmFile << "\n\n;==========Print Library==========\n";
            asmFile << printLibStr << std::endl;
            asmFile << ";==========End of Print Library==========\n";
        }

        asmFile << "\nEND main\n";
        asmFile.flush();
    }

    void printCalled()
    {
        ifstream printLibFile("printproc.asm");

        if (!printLibFile)
        {
            std::cout << "Error opening printProc.asm" << std::endl;
            return;
        }

        std::stringstream buffer;
        buffer << printLibFile.rdbuf();
        printLibStr = buffer.str();

        printLibFile.close();
    }

    void loadAsm(string assemblyCode)
    {

        if (!asmFile)
        {
            std::cout << "Error opening asmFile.txt" << std::endl;
            return;
        }

        asmFile << std::endl
                << assemblyCode << std::endl;

        asmFile.flush();
    }

    void loadTempAsm(string tempCode)
    {
        if (!tempFile)
        {
            cerr << "Error: tempFile is not open." << std::endl;
            return;
        }

        tempFile << "\t" <<  tempCode << endl;

        tempFile.flush();
    }

    void loadAsmWithLabel(string assemblyCode, string label)
    {
        if (!asmFile)
        {
            std::cout << "Error opening asmFile.txt" << std::endl;
            return;
        }

        asmFile << std::endl
                << label << ":" << std::endl;
        asmFile << assemblyCode << std::endl;

        asmFile.flush();
    }

    void loadTempAsmWithLabel(string assemblyCode, string label)
    {
        if (!tempFile)
        {
            std::cout << "Error opening tempFile" << std::endl;
            return;
        }

        tempFile << std::endl
                << label << ":" << std::endl;
        tempFile << assemblyCode << std::endl;

        tempFile.flush();
    }

    void loadFunctionTempAsm(string funcName)
    {
        if (!tempFile)
        {
            std::cout << "Error opening tempFile" << std::endl;
            return;
        }

        tempFile << funcName << " PROC\n";

        if (funcName == "main")
        {
            tempFile << "\tMOV AX, @DATA" << endl
                    << "\tMOV DS, AX" << endl;
        }

        tempFile << "\tPUSH BP" << endl
                << "\tMOV BP, SP" << endl;

        tempFile.flush();

    }

    void unloadFunctionTempAsm(string funcName, int paramOffset, string returnLabel)
    {
        if (!tempFile)
        {
            std::cout << "Error opening tempFile" << std::endl;
            return;
        }

        
        tempFile << returnLabel << ":" << endl;
        
        tempFile << "\tMOV SP, BP" << endl;

        if (funcName == "main")
        {

            tempFile << "\tPOP BP" << endl
                    << "\tMOV AX, 4CH" << endl
                    << "\tINT 21H" << endl;
        }

        else
        {

            tempFile << "\tPOP BP" << endl;

            if (paramOffset == 0)
            {
                tempFile << "\tRET" << endl;
            }
            else
            {
                tempFile << "\tRET " << paramOffset << endl;
            }
        }

        tempFile << funcName << " ENDP\n";
        tempFile.flush();
    }

    void loadCodeFromTempFile()
    {
        if (!tempFile)
        {
            std::cout << "Error opening tempFile" << std::endl;
            return;
        }
        
        tempFile.flush();
        tempFile.close();

        ifstream tempFile("output/temp.asm");
        if (!tempFile.is_open())
        {
            cerr << "Error opening temp file" << endl;
            return;
        }

        string line;
        while (getline(tempFile, line))
        {
            asmFile << line << endl;
        }
        
        asmFile.flush();
        tempFile.close();

        
    }


    int getParamOffset(vector<string> typeList)
    {
        int paramOffset = 0;
        for (const auto& type : typeList)
        {
            if (type == "int")
            {
                paramOffset += 2; // 2 bytes for int
            }
            else if (type == "float")
            {
                paramOffset += 4; // 4 bytes for float
            }
            else 
            {
                //
            }
        }

        return paramOffset;
    }

    string getNewLabel()
    {
        return "L" + to_string(++labelCount);
    }

    

public:
    virtual std::any visitStart(C2105055Parser::StartContext *ctx) override
    {
        asmStart();
        symbolTable = new SymbolTable(7);

        visit(ctx->program());

        loadAsm(".CODE\n");

        loadCodeFromTempFile();

        asmEnd();

        return any();
    }

    virtual std::any visitPROGRAM_PROGRAM_UNIT(C2105055Parser::PROGRAM_PROGRAM_UNITContext *ctx) override 
    {
        
        visit(ctx->program());
        visit(ctx->unit());
        return any();
    }

    virtual std::any visitPROGRAM_UNIT(C2105055Parser::PROGRAM_UNITContext *ctx) override
    {
        visit(ctx->unit());
        return any();
    }

    virtual std::any visitUNIT_VAR_DECLARATION(C2105055Parser::UNIT_VAR_DECLARATIONContext *ctx) override
    {

        visit(ctx->var_declaration());
        return any();
    }

    virtual std::any visitUNIT_FUNC_DECLARATION(C2105055Parser::UNIT_FUNC_DECLARATIONContext *ctx) override
    {
        visit(ctx->func_declaration());
        return any();
    }

    virtual std::any visitUNIT_FUNC_DEFINITION(C2105055Parser::UNIT_FUNC_DEFINITIONContext *ctx) override
    {
        visit(ctx->func_definition());
        return any();
    }

    virtual std::any visitUNIT_STRUCT_DECLARATION(C2105055Parser::UNIT_STRUCT_DECLARATIONContext *ctx) override
    {
        return any();
    }

    virtual std::any visitUNIT_STATEMENT(C2105055Parser::UNIT_STATEMENTContext *ctx) override
    {
        return any();
    }

    virtual std::any visitFUNCDECLARATION_WITH_PARAM_LIST(C2105055Parser::FUNCDECLARATION_WITH_PARAM_LISTContext *ctx) override
    {
        return any();
    }

    virtual std::any visitFUNCDECLARATION_WITHOUT_PARAM_LIST(C2105055Parser::FUNCDECLARATION_WITHOUT_PARAM_LISTContext *ctx) override
    {
        return any();
    }

    virtual std::any visitFUNC_DEF_WITH_PARAM_LIST(C2105055Parser::FUNC_DEF_WITH_PARAM_LISTContext *ctx) override
    {
        symbolTable->enterScope();
        insideNewScope = true;
        string funcName = ctx->ID()->getText();
        
        
        vector<string> typeList = ctx->parameter_list()->typeList.get_variables();
        
        int actualParamOffset = getParamOffset(typeList);
        
        paramOffset = actualParamOffset;
        paramOffset += 2; // for the return address

        visit(ctx->parameter_list());
        paramOffset = 0;

        loadFunctionTempAsm(funcName);
        currentFuncReturnLabel = getNewLabel();

        globalScope = false;
        visit(ctx->compound_statement());
        globalScope = true;
        // insideNewScope = false;

        unloadFunctionTempAsm(funcName, actualParamOffset, currentFuncReturnLabel);

        return any();
    }

    virtual std::any visitFUNC_DEF_WITHOUT_PARAM_LIST(C2105055Parser::FUNC_DEF_WITHOUT_PARAM_LISTContext *ctx) override
    {
        symbolTable->enterScope();
        insideNewScope = true;
        string funcName = ctx->ID()->getText();

        loadFunctionTempAsm(funcName);
        currentFuncReturnLabel = getNewLabel();

        
        globalScope = false;
        visit(ctx->compound_statement());
        // insideNewScope = false;
        globalScope = true;

        unloadFunctionTempAsm(funcName, 0, currentFuncReturnLabel);


        return any();
    }



    virtual std::any visitPARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIER(C2105055Parser::PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIERContext *ctx) override
    {
        return any();
    }

    virtual std::any visitPARAMLIST_TYPE_SPECIFIER(C2105055Parser::PARAMLIST_TYPE_SPECIFIERContext *ctx) override
    {
        return any();
    }

    virtual std::any visitPARAMLIST_error(C2105055Parser::PARAMLIST_errorContext *ctx) override
    {
        return any();
    }

    virtual std::any visitPARAMLIST_TYPE_SPECIFIER_ID(C2105055Parser::PARAMLIST_TYPE_SPECIFIER_IDContext *ctx) override
    {

        string type = ctx->type_specifier()->getText();
        string paramName = ctx->ID()->getText();

        symbolTable->insert(paramName, type);
        SymbolInfo* param = symbolTable->lookUp(paramName);
        if (param)
        {
            param->interpretedType = type;
            param->global = false; // function parameters always local
            param->isArray = false;

            param->setOffset(-paramOffset);
            paramOffset -= param->getSize();
        }

            

        return any();
    }

    virtual std::any visitPARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIER_ID(C2105055Parser::PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIER_IDContext *ctx) override
    {
        visit(ctx->parameter_list());

        string type = ctx->type_specifier()->getText();
        string paramName = ctx->ID()->getText();

        symbolTable->insert(paramName, type);
        SymbolInfo *param = symbolTable->lookUp(paramName);
        if (param)
        {
            param->interpretedType = type;
            param->global = false; // function parameters always local
            param->isArray = false;

            param->setOffset(-paramOffset);
            paramOffset -= param->getSize();
        }


        return any();
    }

    virtual std::any visitCOMPSTMT_STATEMENTS(C2105055Parser::COMPSTMT_STATEMENTSContext *ctx) override
    {

        int tempOffset = symbolTable->getCurrentLocalOffset();
        if (!insideNewScope)
        {

            symbolTable->enterScope();
            symbolTable->addLocalOffset(tempOffset);
        }
        insideNewScope = false;

        visit(ctx->statements());


    //    int localOffset = symbolTable->getCurrentLocalOffset();

    //     if (localOffset != 0)
    //     {
    //         loadTempAsm("\n\t\tADD SP, " + to_string(localOffset) + "\n");
    //     }
        

        symbolTable->addLocalOffset(-tempOffset);
        symbolTable->exitScope();

        return any();
    }

    virtual std::any visitCOMPSTMT_EMPTY(C2105055Parser::COMPSTMT_EMPTYContext *ctx) override
    {
        if (!insideNewScope)
        {
            symbolTable->enterScope();
        }
        insideNewScope = false;

        symbolTable->exitScope();

        return any();
    }

    virtual std::any visitVARDEC_TYPE_SPECIFIER_DECLARATION_LIST_SEMICOLON(C2105055Parser::VARDEC_TYPE_SPECIFIER_DECLARATION_LIST_SEMICOLONContext *ctx) override
    {
        string type = ctx->type_specifier()->getText();

        visit(ctx->declaration_list());

        SymbolInfo* var = nullptr;
        vector<string> variables = ctx->declaration_list()->retList.get_variables();
        for (int i = 0; i < variables.size(); i++)
        {
            var = symbolTable->lookUp(variables[i]);
            if (var)
            {
                var->interpretedType = type;
                var->global = globalScope;

                if (!var->global)
                {
                    if (!var->isArray)
                    {
                        symbolTable->addLocalOffset(var->getSize());
                        var->setOffset(symbolTable->getCurrentLocalOffset());
    
                        cout << "------- OFFSET: " << var->getOffset() << " -------" << endl;
                        // loadTempAsm("\t; ----- OFFSET: " + to_string(var->getOffset()) + " -----");
                        tempFile.flush();
                        loadTempAsm("\n\t\tSUB SP, " + to_string(var->getSize()) + "\n");
                    }
                    else
                    {
                        symbolTable->addLocalOffset(var->getSize());
                        var->setOffset(symbolTable->getCurrentLocalOffset());

                        int totalOffset = var->arrayLength * var->getSize();
                        totalOffset = totalOffset - var->getSize(); // already set the base
                        symbolTable->addLocalOffset(totalOffset);

                        cout << "------- OFFSET: " << var->getOffset() << " -------" << endl;
                        tempFile.flush();
                        loadTempAsm("\n\t\tSUB SP, " + to_string(var->arrayLength * var->getSize()) + "\n");
                    }
                }
                else
                {
                    // into data segment
                    if (!var->isArray)
                    {
                        loadAsm("\t" + var->getSymbolName() + " DW 1 DUP (0000H)");
                    }
                    else
                    {
                        loadAsm("\t" + var->getSymbolName() + " DW " + to_string(var->arrayLength) + " DUP (0000H)");
                    }
                }
            }
        }

        return any();
    }

    virtual std::any visitVARDEC_TYPE_SPECIFIER_SEMICOLON(C2105055Parser::VARDEC_TYPE_SPECIFIER_SEMICOLONContext *ctx) override
    {
        // basically an error
        return any();
    }

    virtual std::any visitVARDEC_STRUCT_ID_DECLARATION_LIST_SEMICOLON(C2105055Parser::VARDEC_STRUCT_ID_DECLARATION_LIST_SEMICOLONContext *ctx) override
    {
        return any();
    }

    // not part of the given grammar. gotta stop working on this cuz of time
    virtual std::any visitVARDEC_TYPE_SPECIFIER_ID_ASSIGNOP_LOGIC_EXPRESSION_SEMICOLON(C2105055Parser::VARDEC_TYPE_SPECIFIER_ID_ASSIGNOP_LOGIC_EXPRESSION_SEMICOLONContext *ctx) override
    {
    

        return any();
    }

    virtual std::any visitVARDECLIST_VARDECLIST_VARDEC(C2105055Parser::VARDECLIST_VARDECLIST_VARDECContext *ctx) override
    {
        visit(ctx->var_declaration());
        visit(ctx->var_declaration_list());
        return any();
    }

    virtual std::any visitVARDECLIST_VARDEC(C2105055Parser::VARDECLIST_VARDECContext *ctx) override
    {
        visit(ctx->var_declaration());
        return any();
    }

    virtual std::any visitStruct_declaration(C2105055Parser::Struct_declarationContext *ctx) override
    {
        return any();
    }

    virtual std::any visitDeclaration_list_err(C2105055Parser::Declaration_list_errContext *ctx) override
    {
        return any();
    }

    virtual std::any visitTYPE_SPECIFIER_INT(C2105055Parser::TYPE_SPECIFIER_INTContext *ctx) override
    {
        return any();
    }

    virtual std::any visitTYPE_SPECIFIER_FLOAT(C2105055Parser::TYPE_SPECIFIER_FLOATContext *ctx) override
    {
        return any();
    }

    virtual std::any visitTYPE_SPECIFIER_VOID(C2105055Parser::TYPE_SPECIFIER_VOIDContext *ctx) override
    {
        return any();
    }

    virtual std::any visitDECLIST_error(C2105055Parser::DECLIST_errorContext *ctx) override
    {
        return any();
    }

    virtual std::any visitDECLIST_DECLIST_COMMA_ID_LTHIRD_CONST_INT_RTHIRD(C2105055Parser::DECLIST_DECLIST_COMMA_ID_LTHIRD_CONST_INT_RTHIRDContext *ctx) override
    {
        visit(ctx->declaration_list());

        string varName = ctx->ID()->getText();
        int arrayLength = stoi(ctx->CONST_INT()->getText());

        symbolTable->insert(varName, "ID");
        
        cout << "\tDecList decList, array" << endl;
        SymbolInfo* varInfo = symbolTable->lookUp(varName);
        
        if (varInfo)
        {
            varInfo->isArray = true;
            varInfo->arrayLength = arrayLength;
            varInfo->global = globalScope;

            // cout << "------- OFFSET: " << varInfo->getOffset() << " -------" << endl;
        }

        return any();
    }

    virtual std::any visitDECLIST_DECLIST_COMMA_ID(C2105055Parser::DECLIST_DECLIST_COMMA_IDContext *ctx) override
    {
        visit(ctx->declaration_list());

        string varName = ctx->ID()->getText();
        symbolTable->insert(varName, "ID");

        cout << "\tDecList decList, variable" << endl;
        SymbolInfo* varInfo = symbolTable->lookUp(varName);
        if (varInfo)
        {
            varInfo->isArray = false;
            varInfo->global = globalScope;

            // cout << "------- OFFSET: " << varInfo->getOffset() << " -------" << endl;
        }


        return any();
    }

    virtual std::any visitDECLIST_ID_LTHIRD_CONST_INT_RTHIRD(C2105055Parser::DECLIST_ID_LTHIRD_CONST_INT_RTHIRDContext *ctx) override
    {
        
        string varName = ctx->ID()->getText();
        int arrayLength = stoi(ctx->CONST_INT()->getText());

        symbolTable->insert(varName, "ID");

        cout << "\tDecList array" << endl;
        SymbolInfo* varInfo = symbolTable->lookUp(varName);
        if (varInfo)
        {
            varInfo->isArray = true;
            varInfo->arrayLength = arrayLength;
            varInfo->global = globalScope;

            // cout << "------- OFFSET: " << varInfo->getOffset() << " -------" << endl;
        }

        return any();
    }

    virtual std::any visitDECLIST_ID(C2105055Parser::DECLIST_IDContext *ctx) override
    {
        string varName = ctx->ID()->getText();
        symbolTable->insert(varName, "ID");

        cout << "\tDecList variable" << endl;
        SymbolInfo* varInfo = symbolTable->lookUp(varName);
        if (varInfo)
        {
            varInfo->isArray = false;
            varInfo->global = globalScope;

            // cout << "------- OFFSET: " << varInfo->getOffset() << " -------" << endl;
        }

        return any();
    }

    virtual std::any visitSTATEMENTS_SINGLE_STATEMENT(C2105055Parser::STATEMENTS_SINGLE_STATEMENTContext *ctx) override
    {
        visit(ctx->statement());
        return any();
    }

    virtual std::any visitSTATEMENTS_MULTI_STATEMENT_SINGLE_STATEMENT(C2105055Parser::STATEMENTS_MULTI_STATEMENT_SINGLE_STATEMENTContext *ctx) override
    {
        visit(ctx->statements());
        visit(ctx->statement());

        return any();
    }

    virtual std::any visitSwitch_case(C2105055Parser::Switch_caseContext *ctx) override
    {
        return any();
    }

    virtual std::any visitDo_while(C2105055Parser::Do_whileContext *ctx) override
    {
        // not part of icg offline T-T
        return any();
    }

    virtual std::any visitSTATEMENT_VAR_DEC(C2105055Parser::STATEMENT_VAR_DECContext *ctx) override
    {
        loadTempAsm("; ##### LINE: " + to_string(ctx->getStart()->getLine()) + " ####\n\n");
        visit(ctx->var_declaration());
        return any();
    }

    virtual std::any visitSTATEMENT_EXPRSTMT(C2105055Parser::STATEMENT_EXPRSTMTContext *ctx) override
    {
        loadTempAsm("; ##### LINE: " + to_string(ctx->getStart()->getLine()) + " ####\n\n");
        visit(ctx->expression_statement());
        return any();
    }

    virtual std::any visitSTATEMENT_COMPOUND_STATEMENT(C2105055Parser::STATEMENT_COMPOUND_STATEMENTContext *ctx) override
    {
        loadTempAsm("; ##### LINE: " + to_string(ctx->getStart()->getLine()) + " ####\n\n");
        visit(ctx->compound_statement());
        return any();
    }

    virtual std::any visitSTATEMENT_FOR(C2105055Parser::STATEMENT_FORContext *ctx) override
    {
        loadTempAsm("; ##### LINE: " + to_string(ctx->getStart()->getLine()) + " ####\n\n");
        //  FOR LPAREN 
        // exprStmt1=expression_statement 
        // exprStmt2=expression_statement 
        // expr=expression 
        // RPAREN
        // STATEMENT
        string forLabel = getNewLabel();
        // string statementsLabel = getNewLabel();
        string forEndLabel = getNewLabel();
        
        visit(ctx->expression_statement(0));

        loadTempAsmWithLabel("", forLabel);

        loadTempAsm("; expression result will be loaded in AX");
        visit(ctx->expression_statement(1));

        loadTempAsm("CMP AX, 0");
        // loadTempAsm("JE " + statementsLabel);
        loadTempAsm("JE " + forEndLabel);

        // loadTempAsmWithLabel("", statementsLabel);
        visit(ctx->statement());

        visit(ctx->expression());

        loadTempAsm("POP AX; Get expression result from stack");

        loadTempAsm("JMP " + forLabel);

        loadTempAsmWithLabel("", forEndLabel);


        return any();
    }

    virtual std::any visitSTATEMENT_IF(C2105055Parser::STATEMENT_IFContext *ctx) override
    {
        loadTempAsm("; ##### LINE: " + to_string(ctx->getStart()->getLine()) + " ####\n\n");
        // IF LPAREN expr=expression RPAREN stmt=statement
        visit(ctx->expression());

        string ifLabel = getNewLabel();
        // string elseLabel = getNewLabel();
        string endIf = getNewLabel();

        loadTempAsm("POP AX; expression result in AX");
        loadTempAsm("CMP AX, 0");

        loadTempAsm("JE " + endIf);
        // loadTempAsm("JNE " + endIf);

        loadTempAsmWithLabel("", ifLabel);
        visit(ctx->statement());
        loadTempAsmWithLabel("", endIf);

        return any();
    }

    virtual std::any visitSTATEMENT_IF_ELSE(C2105055Parser::STATEMENT_IF_ELSEContext *ctx) override
    {
        loadTempAsm("; ##### LINE: " + to_string(ctx->getStart()->getLine()) + " ####\n\n");
        //  IF LPAREN expr=expression RPAREN stmt1=statement ELSE stmt2=statement
        visit(ctx->expression());

        string ifLabel = getNewLabel();
        string elseLabel = getNewLabel();
        string endIf = getNewLabel();


        loadTempAsm("POP AX; expression result in AX");
        loadTempAsm("CMP AX, 0");

        loadTempAsm("JE " + elseLabel);
        // loadTempAsm("JNE " + elseLabel);

        loadTempAsmWithLabel("", ifLabel);
        visit(ctx->statement(0));
        loadTempAsm("JMP " + endIf);

        loadTempAsmWithLabel("", elseLabel);
        visit(ctx->statement(1));
        loadTempAsmWithLabel("", endIf);


        return any();
    }

    virtual std::any visitSTATEMENT_WHILE(C2105055Parser::STATEMENT_WHILEContext *ctx) override
    {
        loadTempAsm("; ##### LINE: " + to_string(ctx->getStart()->getLine()) + " ####\n\n");
        // WHILE LPAREN expr=expression RPAREN stmt=statement

        string whileLabel = getNewLabel();
        string endWhile = getNewLabel();
        // string statementsLabel = getNewLabel();
        
        loadTempAsmWithLabel("", whileLabel);
        visit(ctx->expression());
        loadTempAsm("POP AX; expression result in AX");
        loadTempAsm("CMP AX, 0");
        // loadTempAsm("JE " + statementsLabel);
        loadTempAsm("JE " + endWhile);

        // loadTempAsmWithLabel("", statementsLabel);
        visit(ctx->statement());
        loadTempAsm("JMP " + whileLabel);

        loadTempAsmWithLabel("", endWhile);

        return any();
    }

    virtual std::any visitSTATEMENT_PRINTLN(C2105055Parser::STATEMENT_PRINTLNContext *ctx) override
    {
        loadTempAsm("; ##### LINE: " + to_string(ctx->getStart()->getLine()) + " ####\n\n");
        //  PRINTLN LPAREN ID RPAREN SEMICOLON

        if (!printLibStrLoaded)
        {
            printCalled();
            printLibStrLoaded = true;
        }

        string varName = ctx->ID()->getText();
        SymbolInfo *varInfo = symbolTable->lookUp(varName);
        if (varInfo)
        {

            if (!varInfo->global)
            {
                cout << "------- OFFSET: " << varInfo->getOffset() << " -------" << endl;
                loadTempAsm("; ------- OFFSET: " + to_string(varInfo->getOffset()) + " -------");
                // loadTempAsm("MOV AX, [ BP - " + to_string(varInfo->getOffset()) + " ]");
                
                int offset = varInfo->getOffset();
                if(offset > 0)
                {
                    loadTempAsm("MOV AX, [ BP - " + to_string(varInfo->getOffset()) + " ]");
                }
                else
                {
                    offset = -offset;
                    loadTempAsm("MOV AX, [ BP + " + to_string(offset) + " ]");
                }
            }
            else
            {
                cout << "------- GLOBAL VARIABLE -------" << endl;
                loadTempAsm("; ------- GLOBAL VARIABLE -------");
                loadTempAsm("MOV AX, " + varInfo->getSymbolName());
            }
        }
      
        loadTempAsm("\n\tCALL print_output\n\tCALL new_line\n");
        return any();
    }

    virtual std::any visitSTATEMENT_RETURN(C2105055Parser::STATEMENT_RETURNContext *ctx) override
    {
        loadTempAsm("; ##### LINE: " + to_string(ctx->getStart()->getLine()) + " ####\n\n");
        // RETURN expr=expression SEMICOLON
        if (ctx->expression())
        {
            visit(ctx->expression());
            loadTempAsm("POP AX; Get return value from stack");
        }
        else
        {
            loadTempAsm("MOV AX, 0; No return value, default to 0");
        }

        
        // int localOffset = symbolTable->getCurrentLocalOffset();

        // if (localOffset != 0)
        // {
        //     loadTempAsm("\n\t\tADD SP, " + to_string(localOffset) + "\n");
        // }




        loadTempAsm("JMP " + currentFuncReturnLabel + "; Jump to return label");
        return any();
    }

    virtual std::any visitSTATEMENT_SWITCH_CASE(C2105055Parser::STATEMENT_SWITCH_CASEContext *ctx) override
    {
        loadTempAsm("; ##### LINE: " + to_string(ctx->getStart()->getLine()) + " ####\n\n");
        // won't do it for icg
        // switch_case {logSSA(_input->LT(-1)->getLine(), "switch_case" , $ctx->getText()) ;} #STATEMENT_SWITCH_CASE
        return any();
    }

    virtual std::any visitSTATEMENT_BREAK(C2105055Parser::STATEMENT_BREAKContext *ctx) override
    {
        loadTempAsm("; ##### LINE: " + to_string(ctx->getStart()->getLine()) + " ####\n\n");
        // won't do it for icg
        return any();
    }

    virtual std::any visitSTATEMENT_CONTINUE(C2105055Parser::STATEMENT_CONTINUEContext *ctx) override
    {
        loadTempAsm("; ##### LINE: " + to_string(ctx->getStart()->getLine()) + " ####\n\n");
        // won't do it for icg
        return any();
    }

    virtual std::any visitSTATEMENT_DO_WHILE(C2105055Parser::STATEMENT_DO_WHILEContext *ctx) override
    {
        loadTempAsm("; ##### LINE: " + to_string(ctx->getStart()->getLine()) + " ####\n\n");
        // DO compound_statement WHILE LPAREN expr=expression RPAREN SEMICOLON
        // won't do it for icg
        return any();
    }

    virtual std::any visitCONSTNEW_CONST_INT(C2105055Parser::CONSTNEW_CONST_INTContext *ctx) override
    {
        return any();
    }

    virtual std::any visitCONSTNEW_CONST_FLOAT(C2105055Parser::CONSTNEW_CONST_FLOATContext *ctx) override
    {
        return any();
    }

    virtual std::any visitSWITCHSTATEMENT_CASE_STATEMENT(C2105055Parser::SWITCHSTATEMENT_CASE_STATEMENTContext *ctx) override
    {
        return any();
    }

    virtual std::any visitSWITCHSTATEMENT_CASE_STATEMENT_SWITCHSTATEMENT(C2105055Parser::SWITCHSTATEMENT_CASE_STATEMENT_SWITCHSTATEMENTContext *ctx) override
    {
        return any();
    }

    virtual std::any visitCase_statement(C2105055Parser::Case_statementContext *ctx) override
    {
        return any();
    }

    virtual std::any visitDefault_case_statement(C2105055Parser::Default_case_statementContext *ctx) override
    {
        return any();
    }

    virtual std::any visitEXPRSTMT_SEMICOLON(C2105055Parser::EXPRSTMT_SEMICOLONContext *ctx) override
    {
        loadTempAsm("; ##### LINE: " + to_string(ctx->getStart()->getLine()) + " ####\n\n");
        // empty expr stmt case
        
        return any();
    }

    virtual std::any visitEXPRSTMT_EXPRESSION_SEMICOLON(C2105055Parser::EXPRSTMT_EXPRESSION_SEMICOLONContext *ctx) override
    {
        loadTempAsm("; ##### LINE: " + to_string(ctx->getStart()->getLine()) + " ####\n\n");
        visit(ctx->expression());

        loadTempAsm("POP AX; expr statement value in AX now");


        return any();
    }

    virtual std::any visitVARIABLE_ID(C2105055Parser::VARIABLE_IDContext *ctx) override
    {

        string varName = ctx->ID()->getText();
        SymbolInfo *varInfo = symbolTable->lookUp(varName);
        if (varInfo)
        {

            if (!varInfo->global)
            {
                cout << "------- OFFSET: " << varInfo->getOffset() << " -------" << endl;
                loadTempAsm("; ------- OFFSET: " + to_string(varInfo->getOffset()) + " -------");
                // loadTempAsm("MOV AX, [ BP - " + to_string(varInfo->getOffset()) + " ]");
                
                int offset = varInfo->getOffset();
                if(offset > 0)
                {
                    return string("[ BP - " + to_string(offset) + " ]");
                }
                else
                {
                    offset = -offset;
                    return string("[ BP + " + to_string(offset) + " ]");
                }
            }
            else
            {
                cout << "------- GLOBAL VARIABLE -------" << endl;
                loadTempAsm("; ------- GLOBAL VARIABLE -------");
                // loadTempAsm("MOV AX, " + varInfo->getSymbolName());
                return string(varInfo->getSymbolName());
            }
        }
        // loadTempAsm("PUSH AX\n");
        return any();
    }

    virtual std::any visitVARIABLE_ID_LTHIRD_EXPRESSION_RTHIRD(C2105055Parser::VARIABLE_ID_LTHIRD_EXPRESSION_RTHIRDContext *ctx) override
    {
        
        string varName = ctx->ID()->getText();
        SymbolInfo *varInfo = symbolTable->lookUp(varName);
        
        visit(ctx->expression());

        loadTempAsm("POP BX  ; Get index from stack");
        loadTempAsm("MOV AX, " + to_string(varInfo->getSize()) + "  ; Size of each element in the array");
        loadTempAsm("MUL BX  ; AX = index * size");
        loadTempAsm("MOV BX, AX  ; Store offset in BX");
        
        if (varInfo)
        {
            if (!varInfo->global)
            {
                cout << "------- ARRAY BASE OFFSET: " << varInfo->getOffset() << " -------" << endl;
                loadTempAsm("; ------- ARRAY BASE OFFSET: " + to_string(varInfo->getOffset()) + " -------");
                loadTempAsm("MOV AX, " + to_string(varInfo->getOffset()) + "  ; Base offset of the array from stack top");

                loadTempAsm("MOV SI, AX  ; Store base offset in SI");
                loadTempAsm("ADD SI, BX  ; Add index offset to base offset");
                loadTempAsm("NEG SI ");
                // loadTempAsm("MOV AX, [ BP + SI ]  ; Load value from array at index");
                return string("[BP + SI]");

            }
            else
            {
                cout << "------- GLOBAL ARRAY VARIABLE -------" << endl;
                loadTempAsm("; ------- GLOBAL ARRAYVARIABLE -------");
                // loadTempAsm("MOV AX, " + varInfo->getSymbolName() + "[BX]  ; Load value from global array at index");
                return string( string(varInfo->getSymbolName()) + "[BX]");
                
            }
        }

        // loadTempAsm("PUSH AX  ; Push value back to stack\n");

        
    }

    virtual std::any visitEXPRESSION_LOGIC_EXPRESSION(C2105055Parser::EXPRESSION_LOGIC_EXPRESSIONContext *ctx) override
    {
        visit(ctx->logic_expression());
        return any();
    }

    virtual std::any visitEXPRESSION_VARIABLE_ASSIGNOP_EXPRESSION(C2105055Parser::EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext *ctx) override
    {
        // not part of icg offline tho

        
        visit(ctx->expression());
        
        loadTempAsm("POP CX; expression result in CX");
        
        
        string variableAddress = any_cast<string>(visit(ctx->variable()));
        loadTempAsm("MOV " + variableAddress + ", CX  ; Store result in variable");


        loadTempAsm("PUSH CX  ; Push expr result back to stack\n");
        
        return any();
    }

    virtual std::any visitEXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSION(C2105055Parser::EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext *ctx) override
    {

        visit(ctx->logic_expression());
        
        loadTempAsm("POP CX; logic expression result in CX");
        
        
        string variableAddress = any_cast<string>(visit(ctx->variable()));
        loadTempAsm("MOV " + variableAddress + ", CX  ; Store result in variable");


        loadTempAsm("PUSH CX  ; Push expr result back to stack\n");

        return any();
    }

    virtual std::any visitEXPRESSION_EXPRESSION_UNRECOGNIZED_CHAR(C2105055Parser::EXPRESSION_EXPRESSION_UNRECOGNIZED_CHARContext *ctx) override
    {
        return any();
    }

    virtual std::any visitLOGICEXPRESSION_REL_EXPRESSION(C2105055Parser::LOGICEXPRESSION_REL_EXPRESSIONContext *ctx) override
    {
        visit(ctx->rel_expression());
        return any();
    }

    virtual std::any visitLOGICEXPRESSION_REL_EXPRESSION_LOGICOP_REL_EXPRESSION(C2105055Parser::LOGICEXPRESSION_REL_EXPRESSION_LOGICOP_REL_EXPRESSIONContext *ctx) override
    {
        visit(ctx->rel_expression(0));
        loadTempAsm("POP AX");

        string operation = ctx->LOGICOP()->getText();

        if (operation == "&&")
        {
            // Short-circuit AND: if first operand is false, don't evaluate second
            loadTempAsm("CMP AX, 0");
            string falseLabel = getNewLabel();
            string endLabel = getNewLabel();

            // If first operand is false (0), jump to false result
            loadTempAsm("JE " + falseLabel);

            // First operand is true, evaluate second operand
            visit(ctx->rel_expression(1));
            loadTempAsm("POP AX");
            loadTempAsm("CMP AX, 0");

            // If second operand is false, jump to false result
            loadTempAsm("JE " + falseLabel);

            // Both operands are true, result is true
            loadTempAsm("PUSH 1");
            loadTempAsm("JMP " + endLabel);

            // At least one operand is false, result is false
            loadTempAsmWithLabel("PUSH 0", falseLabel);
            loadTempAsmWithLabel("", endLabel);
        }
        else if (operation == "||")
        {
            // Short-circuit OR: if first operand is true, don't evaluate second
            loadTempAsm("CMP AX, 0");
            string trueLabel = getNewLabel();
            string endLabel = getNewLabel();

            // If first operand is true (non-zero), jump to true result
            loadTempAsm("JNE " + trueLabel);

            // First operand is false, evaluate second operand
            visit(ctx->rel_expression(1));
            loadTempAsm("POP AX");
            loadTempAsm("CMP AX, 0");

            // If second operand is true, jump to true result
            loadTempAsm("JNE " + trueLabel);

            // Both operands are false, result is false
            loadTempAsm("PUSH 0");
            loadTempAsm("JMP " + endLabel);

            // At least one operand is true, result is true
            loadTempAsmWithLabel("PUSH 1", trueLabel);
            loadTempAsmWithLabel("", endLabel);
        }

        return any();
    }

    
    virtual std::any visitRELEXPRESSION_SIMPLE_EXPRESSION(C2105055Parser::RELEXPRESSION_SIMPLE_EXPRESSIONContext *ctx) override
    {
        visit(ctx->simple_expression());
        return any();
    }

    virtual std::any visitRELEXPRESSION_SIMPLE_EXPRESSION_RELOP_SIMPLE_EXPRESSION(C2105055Parser::RELEXPRESSION_SIMPLE_EXPRESSION_RELOP_SIMPLE_EXPRESSIONContext *ctx) override
    {
        visit(ctx->simple_expression(0));
        visit(ctx->simple_expression(1));

        loadTempAsm("POP BX; rhs of relop");
        loadTempAsm("POP AX; lhs of relop"); 

        loadTempAsm("CMP AX, BX");

        // '<=' | '==' | '>=' | '>' | '<' | '!='
        
        
        // 2 LABEL VERSION
        
        string operation = ctx->RELOP()->getText();
        string endIf = getNewLabel();
        string falseLabel = getNewLabel();

        if (operation == "<=")
        {
            loadTempAsm("JG " + falseLabel);
        }
        else if (operation == "==")
        {
            loadTempAsm("JNE " + falseLabel);
        }
        else if (operation == ">=")
        {
            loadTempAsm("JL " + falseLabel);
        }
        else if (operation == ">")
        {
            loadTempAsm("JLE " + falseLabel);
        }
        else if (operation == "<")
        {
            loadTempAsm("JGE " + falseLabel);
        }
        else if (operation == "!=")
        {
            loadTempAsm("JE " + falseLabel);
        }

        loadTempAsm("PUSH 1");
        loadTempAsm("JMP " + endIf);

        loadTempAsmWithLabel("PUSH 0", falseLabel);
        loadTempAsmWithLabel("", endIf);


        return any();
    }

    virtual std::any visitSIMPLEEXPRESSION_SIMPLE_EXPRESSION_ADDOP_TERM(C2105055Parser::SIMPLEEXPRESSION_SIMPLE_EXPRESSION_ADDOP_TERMContext *ctx) override
    {
        visit(ctx->simple_expression());
        // Don't pop yet - keep first operand on stack

        visit(ctx->term());
        loadTempAsm("POP AX  ; Get second operand (term result)");
        loadTempAsm("POP BX  ; Get first operand (simple_expression result)");

        string operation = ctx->ADDOP()->getText();

        if (operation == "+")
        {
            loadTempAsm("ADD AX, BX  ; AX = term + simple_expression");
        }
        else
        {
            loadTempAsm("SUB BX, AX  ; BX = simple_expression - term");
            loadTempAsm("MOV AX, BX  ; Move result to AX");
        }

        loadTempAsm("PUSH AX  ; Push result\n");

        return any();
    }

    virtual std::any visitSIMPLEEXPRESSION_TERM(C2105055Parser::SIMPLEEXPRESSION_TERMContext *ctx) override
    {
        visit(ctx->term());
        return any();
    }

    virtual std::any visitTERM_ASSIGNOP(C2105055Parser::TERM_ASSIGNOPContext *ctx) override
    {
        // basically an error
        return any();
    }

    virtual std::any visitTERM_TERM_MULOP_UNARY_EXPRESSION(C2105055Parser::TERM_TERM_MULOP_UNARY_EXPRESSIONContext *ctx) override
    {
        visit(ctx->term());
        
        visit(ctx->unary_expression());
        loadTempAsm("POP CX  ; Get second operand (multiplier)");
        loadTempAsm("POP BX  ; Get first operand (multiplicand)");

        // Get the operation type
        string operation = ctx->MULOP()->getText();

        // Handle different operations
        if (operation == "*")
        {
            loadTempAsm("MOV AX, BX  ; Move multiplicand to AX");
            loadTempAsm("IMUL CX  ; AX = AX * CX");
            loadTempAsm("PUSH AX  ; Push result\n\n");
        }
        else if (operation == "/")
        {
            loadTempAsm("MOV AX, BX  ; Move dividend to AX");
            loadTempAsm("CWD  ; Sign extend AX into DX");
            loadTempAsm("IDIV CX  ; AX = BX / CX");
            loadTempAsm("PUSH AX  ; Push quotient\n\n");
        }
        else if (operation == "%")
        {
            loadTempAsm("MOV AX, BX  ; Move dividend to AX");
            loadTempAsm("CWD  ; Sign extend AX into DX");
            loadTempAsm("IDIV CX  ; AX = quotient, DX = remainder");
            loadTempAsm("PUSH DX  ; Push remainder\n\n");
        }

        return any();
    }

    virtual std::any visitTERM_UNARY_EXPRESSION(C2105055Parser::TERM_UNARY_EXPRESSIONContext *ctx) override
    {
        visit(ctx->unary_expression());
        return any();
    }

    virtual std::any visitUNARYEXPRESSION_ADDOP_UNARY_EXPRESSION(C2105055Parser::UNARYEXPRESSION_ADDOP_UNARY_EXPRESSIONContext *ctx) override
    {
        visit(ctx->unary_expression());
        loadTempAsm("POP AX  ; Get operand");

        string operation = ctx->ADDOP()->getText();
        if (operation == "+")
        {
            // Do nothing, just push the value
            loadTempAsm("PUSH AX  ; Push value unchanged\n");
        }
        else if (operation == "-")
        {
            loadTempAsm("NEG AX  ; Negate the value");
            loadTempAsm("PUSH AX  ; Push negated value\n");
        }

        return any();
    }

    virtual std::any visitUNARYEXPRESSION_NOT_UNARY_EXPRESSION(C2105055Parser::UNARYEXPRESSION_NOT_UNARY_EXPRESSIONContext *ctx) override
    {
        visit(ctx->unary_expression());
        loadTempAsm("POP AX  ; Get operand");

        // Logical NOT: if AX == 0, result = 1; else result = 0
        loadTempAsm("CMP AX, 0");
        string falseLabel = getNewLabel();
        string endLabel = getNewLabel();
        
        loadTempAsm("JE " + falseLabel + " ; Jump if operand is 0 (false)");
        
        // Operand is non-zero (true), so result should be 0 (false)
        loadTempAsm("PUSH 0 ; !true = false");
        loadTempAsm("JMP " + endLabel);
        
        // Operand is zero (false), so result should be 1 (true)  
        loadTempAsmWithLabel("PUSH 1 ; !false = true", falseLabel);
        loadTempAsmWithLabel("", endLabel);

        return any();
    }

    virtual std::any visitUNARYEXPRESSION_FACTOR(C2105055Parser::UNARYEXPRESSION_FACTORContext *ctx) override
    {
        visit(ctx->factor());
        return any();
    }

    virtual std::any visitFACTOR_VARIABLE(C2105055Parser::FACTOR_VARIABLEContext *ctx) override
    {
        string variableAddress = any_cast<string>(visit(ctx->variable()));

        loadTempAsm("MOV AX, " + variableAddress);
        loadTempAsm("PUSH AX; pushing from factor: varibale");

        return any();
    }

    virtual std::any visitFACTOR_FUNCTION_CALL(C2105055Parser::FACTOR_FUNCTION_CALLContext *ctx) override
    {
        // factor : ID LPAREN argument_list? RPAREN SEMICOLON

        if(ctx->argument_list())
        {
            visit(ctx->argument_list());
        }
        else
        {
            loadTempAsm("; No arguments");
        }

        loadTempAsm("; all params loaded");

        string functionName = ctx->ID()->getText();
        cout << "------- FUNCTION CALL: " << functionName << " -------" << endl;
        loadTempAsm("CALL " + functionName + "\n");
        
        loadTempAsm("PUSH AX; pushing function call result to stack");


        return any();
    }

    virtual std::any visitFACTOR_EXPRESSION(C2105055Parser::FACTOR_EXPRESSIONContext *ctx) override
    {
        visit(ctx->expression());
        return any();
    }

    virtual std::any visitFACTOR_CONST_INT(C2105055Parser::FACTOR_CONST_INTContext *ctx) override
    {
        string constInt = ctx->CONST_INT()->getText();
        cout << "------- CONST INT: " << constInt << " -------" << endl;

        loadTempAsm("PUSH " + constInt + " ; const int\n");

        return any();
    }

    virtual std::any visitFACTOR_CONST_FLOAT(C2105055Parser::FACTOR_CONST_FLOATContext *ctx) override
    {
        string constFloat = ctx->CONST_FLOAT()->getText();

        loadTempAsm("PUSH " + constFloat + " ; const float\n");
        return any();
    }

    virtual std::any visitFACTOR_VARIABLE_INC(C2105055Parser::FACTOR_VARIABLE_INCContext *ctx) override
    {
        
        string variableAddress = any_cast<string>(visit(ctx->variable()));

        loadTempAsm("MOV AX, " + variableAddress);
        loadTempAsm("PUSH AX; pushing from factor: varibale");


        loadTempAsm("INC AX; incremented value stored in AX");


        // now we write the new value back to the variable address
        loadTempAsm("MOV " + variableAddress + ", AX  ; Store result in variable");


        return any();
    }

    virtual std::any visitFACTOR_VARIABLE_DEC(C2105055Parser::FACTOR_VARIABLE_DECContext *ctx) override
    {

        string variableAddress = any_cast<string>(visit(ctx->variable()));

        loadTempAsm("MOV AX, " + variableAddress);
        loadTempAsm("PUSH AX; pushing from factor: varibale");


        loadTempAsm("DEC AX; decremented value stored in AX");


        // now we write the new value back to the variable address
        loadTempAsm("MOV " + variableAddress + ", AX  ; Store result in variable");



        return any();
    }

    virtual std::any visitArgument_list(C2105055Parser::Argument_listContext *ctx) override
    {
        // argument_list: arguments

        if (ctx->arguments())
        {
            visit(ctx->arguments());
        }
        else
        {
            loadTempAsm("; No arguments");
        }
        return any();
    }

    virtual std::any visitARGUMENTS_LOGIC_EXPRESSION(C2105055Parser::ARGUMENTS_LOGIC_EXPRESSIONContext *ctx) override
    {
        // arguments: logic_expression
        visit(ctx->logic_expression());

        // loadTempAsm("POP AX; logic expression result in AX");
        // loadTempAsm("PUSH AX; pushing logic expression result to stack for function call");

        loadTempAsm("; Parameter already pushed by logic expression");

        return any();
    }

    virtual std::any visitARGUMENTS_ARGUMENTS_COMMA_LOGIC_EXPRESSION(C2105055Parser::ARGUMENTS_ARGUMENTS_COMMA_LOGIC_EXPRESSIONContext *ctx) override
    {
        // arguments: arguments ',' logic_expression
        visit(ctx->arguments());
        visit(ctx->logic_expression());

        // loadTempAsm("POP AX; logic expression result in AX");
        // loadTempAsm("PUSH AX; pushing logic expression result to stack for function call

        loadTempAsm("; Parameter already pushed by logic expression");

        return any();
    }
};

#endif