// Generated from e://CODE//C++//cpp_Works//compiler//3_ssanalyzer//ssanalyzer//C2105055Parser.g4 by ANTLR 4.13.1

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
    
    


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class C2105055Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LINE_COMMENT=1, BLOCK_COMMENT=2, STRING=3, WS=4, IF=5, ELSE=6, SWITCH=7, 
		CASE=8, DEFAULT=9, BREAK=10, CONTINUE=11, FOR=12, WHILE=13, DO=14, PRINTF=15, 
		RETURN=16, INT=17, FLOAT=18, VOID=19, STRUCT=20, LPAREN=21, RPAREN=22, 
		LCURL=23, RCURL=24, LTHIRD=25, RTHIRD=26, SEMICOLON=27, COMMA=28, COLON=29, 
		ADDOP=30, SUBOP=31, MULOP=32, INCOP=33, DECOP=34, NOT=35, RELOP=36, LOGICOP=37, 
		ASSIGNOP=38, ID=39, CONST_INT=40, CONST_FLOAT=41, UNRECOGNIZED_CHAR=42;
	public static final int
		RULE_start = 0, RULE_program = 1, RULE_unit = 2, RULE_func_declaration = 3, 
		RULE_func_definition = 4, RULE_parameter_list = 5, RULE_compound_statement = 6, 
		RULE_var_declaration = 7, RULE_var_declaration_list = 8, RULE_struct_declaration = 9, 
		RULE_declaration_list_err = 10, RULE_type_specifier = 11, RULE_declaration_list = 12, 
		RULE_statements = 13, RULE_switch_case = 14, RULE_do_while = 15, RULE_statement = 16, 
		RULE_const_new = 17, RULE_switch_statement = 18, RULE_case_statement = 19, 
		RULE_default_case_statement = 20, RULE_expression_statement = 21, RULE_variable = 22, 
		RULE_expression = 23, RULE_logic_expression = 24, RULE_rel_expression = 25, 
		RULE_simple_expression = 26, RULE_term = 27, RULE_unary_expression = 28, 
		RULE_factor = 29, RULE_argument_list = 30, RULE_arguments = 31;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "program", "unit", "func_declaration", "func_definition", "parameter_list", 
			"compound_statement", "var_declaration", "var_declaration_list", "struct_declaration", 
			"declaration_list_err", "type_specifier", "declaration_list", "statements", 
			"switch_case", "do_while", "statement", "const_new", "switch_statement", 
			"case_statement", "default_case_statement", "expression_statement", "variable", 
			"expression", "logic_expression", "rel_expression", "simple_expression", 
			"term", "unary_expression", "factor", "argument_list", "arguments"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'if'", "'else'", "'switch'", "'case'", 
			"'default'", "'break'", "'continue'", "'for'", "'while'", "'do'", "'printf'", 
			"'return'", "'int'", "'float'", "'void'", "'struct'", "'('", "')'", "'{'", 
			"'}'", "'['", "']'", "';'", "','", "':'", null, null, null, "'++'", "'--'", 
			"'!'", null, null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LINE_COMMENT", "BLOCK_COMMENT", "STRING", "WS", "IF", "ELSE", 
			"SWITCH", "CASE", "DEFAULT", "BREAK", "CONTINUE", "FOR", "WHILE", "DO", 
			"PRINTF", "RETURN", "INT", "FLOAT", "VOID", "STRUCT", "LPAREN", "RPAREN", 
			"LCURL", "RCURL", "LTHIRD", "RTHIRD", "SEMICOLON", "COMMA", "COLON", 
			"ADDOP", "SUBOP", "MULOP", "INCOP", "DECOP", "NOT", "RELOP", "LOGICOP", 
			"ASSIGNOP", "ID", "CONST_INT", "CONST_FLOAT", "UNRECOGNIZED_CHAR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "C2105055Parser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    
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




	public C2105055Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public ProgramContext prog;
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
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
			            

			        
			setState(65);
			((StartContext)_localctx).prog = program(0);

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
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public std::string programStr;
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	 
		public ProgramContext() { }
		public void copyFrom(ProgramContext ctx) {
			super.copyFrom(ctx);
			this.programStr = ctx.programStr;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PROGRAM_PROGRAM_UNITContext extends ProgramContext {
		public ProgramContext p;
		public UnitContext u;
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public UnitContext unit() {
			return getRuleContext(UnitContext.class,0);
		}
		public PROGRAM_PROGRAM_UNITContext(ProgramContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PROGRAM_UNITContext extends ProgramContext {
		public UnitContext u;
		public UnitContext unit() {
			return getRuleContext(UnitContext.class,0);
		}
		public PROGRAM_UNITContext(ProgramContext ctx) { copyFrom(ctx); }
	}

	public final ProgramContext program() throws RecognitionException {
		return program(0);
	}

	private ProgramContext program(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ProgramContext _localctx = new ProgramContext(_ctx, _parentState);
		ProgramContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_program, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new PROGRAM_UNITContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(69);
			((PROGRAM_UNITContext)_localctx).u = unit();

			            ((PROGRAM_UNITContext)_localctx).programStr =  ((PROGRAM_UNITContext)_localctx).u.unitStr;
			            // std::cout << "((PROGRAM_UNITContext)_localctx).u.unitStr: " << ((PROGRAM_UNITContext)_localctx).u.unitStr << std::endl;
			            logSSA(_input->LT(-1)->getLine(), "program : unit", 
			                _localctx.programStr);
			        
			}
			_ctx.stop = _input.LT(-1);
			setState(78);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PROGRAM_PROGRAM_UNITContext(new ProgramContext(_parentctx, _parentState));
					((PROGRAM_PROGRAM_UNITContext)_localctx).p = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_program);
					setState(72);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(73);
					((PROGRAM_PROGRAM_UNITContext)_localctx).u = unit();

					                      ((PROGRAM_PROGRAM_UNITContext)_localctx).programStr =  ((PROGRAM_PROGRAM_UNITContext)_localctx).p.programStr + "\n" + ((PROGRAM_PROGRAM_UNITContext)_localctx).u.unitStr;
					                      // // std::cout << "((PROGRAM_PROGRAM_UNITContext)_localctx).u.unitStr: " << _localctx.programStr << std::endl;
					                      logSSA(_input->LT(-1)->getLine(), "program : program unit", 
					                          _localctx.programStr);
					                  
					}
					} 
				}
				setState(80);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnitContext extends ParserRuleContext {
		public std::string unitStr;
		public UnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unit; }
	 
		public UnitContext() { }
		public void copyFrom(UnitContext ctx) {
			super.copyFrom(ctx);
			this.unitStr = ctx.unitStr;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UNIT_FUNC_DECLARATIONContext extends UnitContext {
		public Func_declarationContext funcDec;
		public Func_declarationContext func_declaration() {
			return getRuleContext(Func_declarationContext.class,0);
		}
		public UNIT_FUNC_DECLARATIONContext(UnitContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UNIT_VAR_DECLARATIONContext extends UnitContext {
		public Var_declarationContext vd;
		public Var_declarationContext var_declaration() {
			return getRuleContext(Var_declarationContext.class,0);
		}
		public UNIT_VAR_DECLARATIONContext(UnitContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UNIT_STATEMENTContext extends UnitContext {
		public StatementContext statement;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public UNIT_STATEMENTContext(UnitContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UNIT_STRUCT_DECLARATIONContext extends UnitContext {
		public Struct_declarationContext structDec;
		public Struct_declarationContext struct_declaration() {
			return getRuleContext(Struct_declarationContext.class,0);
		}
		public UNIT_STRUCT_DECLARATIONContext(UnitContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UNIT_FUNC_DEFINITIONContext extends UnitContext {
		public Func_definitionContext funcDef;
		public Func_definitionContext func_definition() {
			return getRuleContext(Func_definitionContext.class,0);
		}
		public UNIT_FUNC_DEFINITIONContext(UnitContext ctx) { copyFrom(ctx); }
	}

	public final UnitContext unit() throws RecognitionException {
		UnitContext _localctx = new UnitContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_unit);
		try {
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new UNIT_VAR_DECLARATIONContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				((UNIT_VAR_DECLARATIONContext)_localctx).vd = var_declaration();

				            ((UNIT_VAR_DECLARATIONContext)_localctx).unitStr =  ((UNIT_VAR_DECLARATIONContext)_localctx).vd.varDecStr;
				            // std::cout << "((UNIT_VAR_DECLARATIONContext)_localctx).vd.varDecStr: " << ((UNIT_VAR_DECLARATIONContext)_localctx).vd.varDecStr << std::endl;
				            logSSA(_input->LT(-1)->getLine(), "unit : var_declaration", ((UNIT_VAR_DECLARATIONContext)_localctx).vd.varDecStr);
				        
				}
				break;
			case 2:
				_localctx = new UNIT_FUNC_DECLARATIONContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				((UNIT_FUNC_DECLARATIONContext)_localctx).funcDec = func_declaration();

				            ((UNIT_FUNC_DECLARATIONContext)_localctx).unitStr =  ((UNIT_FUNC_DECLARATIONContext)_localctx).funcDec.funcDeclarationStr;
				            // std::cout << "((UNIT_FUNC_DECLARATIONContext)_localctx).funcDec.funcDeclarationStr: " << ((UNIT_FUNC_DECLARATIONContext)_localctx).funcDec.funcDeclarationStr << std::endl;
				            logSSA(_input->LT(-1)->getLine(), "unit : func_declaration", _localctx.unitStr);
				            // writeIntoparserLogFile("Function Declaration: " + _localctx.unitStr);
				        
				}
				break;
			case 3:
				_localctx = new UNIT_FUNC_DEFINITIONContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				((UNIT_FUNC_DEFINITIONContext)_localctx).funcDef = func_definition();

				            ((UNIT_FUNC_DEFINITIONContext)_localctx).unitStr =  ((UNIT_FUNC_DEFINITIONContext)_localctx).funcDef.funcDefStr;
				            // std::cout << "((UNIT_FUNC_DEFINITIONContext)_localctx).funcDef.funcDefStr: " << ((UNIT_FUNC_DEFINITIONContext)_localctx).funcDef.funcDefStr << std::endl;
				            logSSA(_input->LT(-1)->getLine(), "unit : func_definition", _localctx.unitStr);
				            // writeIntoparserLogFile("Function Definition: " + _localctx.unitStr);
				        
				}
				break;
			case 4:
				_localctx = new UNIT_STRUCT_DECLARATIONContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(90);
				((UNIT_STRUCT_DECLARATIONContext)_localctx).structDec = struct_declaration();

				            ((UNIT_STRUCT_DECLARATIONContext)_localctx).unitStr =  ((UNIT_STRUCT_DECLARATIONContext)_localctx).structDec.structDeclarationStr;
				            logSSA(_input->LT(-1)->getLine(), "unit : struct_declaration", _localctx.unitStr);
				        
				}
				break;
			case 5:
				_localctx = new UNIT_STATEMENTContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(93);
				((UNIT_STATEMENTContext)_localctx).statement = statement();

				            ((UNIT_STATEMENTContext)_localctx).unitStr =  ((UNIT_STATEMENTContext)_localctx).statement.stmtStr;
				            logSSA(_input->LT(-1)->getLine(), "unit : statement", _localctx.unitStr);
				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Func_declarationContext extends ParserRuleContext {
		public std::string funcDeclarationStr;
		public Func_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_declaration; }
	 
		public Func_declarationContext() { }
		public void copyFrom(Func_declarationContext ctx) {
			super.copyFrom(ctx);
			this.funcDeclarationStr = ctx.funcDeclarationStr;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FUNCDECLARATION_WITH_PARAM_LISTContext extends Func_declarationContext {
		public Type_specifierContext ts;
		public Token ID;
		public Parameter_listContext pl;
		public TerminalNode ID() { return getToken(C2105055Parser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(C2105055Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(C2105055Parser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(C2105055Parser.SEMICOLON, 0); }
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public FUNCDECLARATION_WITH_PARAM_LISTContext(Func_declarationContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FUNCDECLARATION_WITHOUT_PARAM_LISTContext extends Func_declarationContext {
		public Type_specifierContext ts;
		public Token ID;
		public TerminalNode ID() { return getToken(C2105055Parser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(C2105055Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(C2105055Parser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(C2105055Parser.SEMICOLON, 0); }
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public FUNCDECLARATION_WITHOUT_PARAM_LISTContext(Func_declarationContext ctx) { copyFrom(ctx); }
	}

	public final Func_declarationContext func_declaration() throws RecognitionException {
		Func_declarationContext _localctx = new Func_declarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_func_declaration);
		try {
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new FUNCDECLARATION_WITH_PARAM_LISTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				((FUNCDECLARATION_WITH_PARAM_LISTContext)_localctx).ts = type_specifier();
				setState(99);
				((FUNCDECLARATION_WITH_PARAM_LISTContext)_localctx).ID = match(ID);
				setState(100);
				match(LPAREN);
				setState(101);
				((FUNCDECLARATION_WITH_PARAM_LISTContext)_localctx).pl = parameter_list(0);
				setState(102);
				match(RPAREN);
				setState(103);
				match(SEMICOLON);

				                ((FUNCDECLARATION_WITH_PARAM_LISTContext)_localctx).funcDeclarationStr =  ((FUNCDECLARATION_WITH_PARAM_LISTContext)_localctx).ts.type + " " + ((FUNCDECLARATION_WITH_PARAM_LISTContext)_localctx).ID->getText() + "(" + ((FUNCDECLARATION_WITH_PARAM_LISTContext)_localctx).pl.paramListStr.get_list_as_string() + ");";
				                logSSA(_input->LT(-1)->getLine(), "func_declaration : type_specifier ID LPAREN parameter_list RPAREN SEMICOLON",
				                    _localctx.funcDeclarationStr);

				                if(symbolTable->insert(((FUNCDECLARATION_WITH_PARAM_LISTContext)_localctx).ID->getText(), "ID") == false)
				                {
				                    logError(_input->LT(-1)->getLine(), "Multiple declaration of " + ((FUNCDECLARATION_WITH_PARAM_LISTContext)_localctx).ID->getText());
				                    semanticErrorCount++;
				                }
				                else
				                {
				                    currentFunction = ((FUNCDECLARATION_WITH_PARAM_LISTContext)_localctx).ID->getText();
				                    SymbolInfo* func = symbolTable->lookUp(((FUNCDECLARATION_WITH_PARAM_LISTContext)_localctx).ID->getText());
				                    func->makeFunctionSymbol(((FUNCDECLARATION_WITH_PARAM_LISTContext)_localctx).ts.type, ((FUNCDECLARATION_WITH_PARAM_LISTContext)_localctx).pl.typeList.get_variables(), ((FUNCDECLARATION_WITH_PARAM_LISTContext)_localctx).pl.paramList.get_variables());
				                    // cout << ((FUNCDECLARATION_WITH_PARAM_LISTContext)_localctx).pl.typeList.get_list_as_string() << endl << ((FUNCDECLARATION_WITH_PARAM_LISTContext)_localctx).pl.paramList.get_list_as_string() << endl;
				                }
				                funcRetType = ((FUNCDECLARATION_WITH_PARAM_LISTContext)_localctx).ts.type;




				                



				                // writeIntoparserLogFile("Function Declaration: " + _localctx.funcDeclarationStr);
				            
				}
				break;
			case 2:
				_localctx = new FUNCDECLARATION_WITHOUT_PARAM_LISTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				((FUNCDECLARATION_WITHOUT_PARAM_LISTContext)_localctx).ts = type_specifier();
				setState(107);
				((FUNCDECLARATION_WITHOUT_PARAM_LISTContext)_localctx).ID = match(ID);
				setState(108);
				match(LPAREN);
				setState(109);
				match(RPAREN);
				setState(110);
				match(SEMICOLON);

				                ((FUNCDECLARATION_WITHOUT_PARAM_LISTContext)_localctx).funcDeclarationStr =  ((FUNCDECLARATION_WITHOUT_PARAM_LISTContext)_localctx).ts.type + " " + ((FUNCDECLARATION_WITHOUT_PARAM_LISTContext)_localctx).ID->getText() + "();";
				                logSSA(_input->LT(-1)->getLine(), "func_declaration : type_specifier ID LPAREN RPAREN SEMICOLON",
				                    _localctx.funcDeclarationStr);
				                if(symbolTable->insert(((FUNCDECLARATION_WITHOUT_PARAM_LISTContext)_localctx).ID->getText(), "ID") == false)
				                {
				                    logError(_input->LT(-1)->getLine(), "Multiple declaration of " + ((FUNCDECLARATION_WITHOUT_PARAM_LISTContext)_localctx).ID->getText());
				                    semanticErrorCount++;
				                }
				                else
				                {
				                    currentFunction = ((FUNCDECLARATION_WITHOUT_PARAM_LISTContext)_localctx).ID->getText();
				                    SymbolInfo* func = symbolTable->lookUp(((FUNCDECLARATION_WITHOUT_PARAM_LISTContext)_localctx).ID->getText());
				                    func->makeFunctionSymbol(((FUNCDECLARATION_WITHOUT_PARAM_LISTContext)_localctx).ts.type, {}, {});
				                }
				                funcRetType = ((FUNCDECLARATION_WITHOUT_PARAM_LISTContext)_localctx).ts.type;

				                // writeIntoparserLogFile("Function Declaration: " + _localctx.funcDeclarationStr);
				            
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Func_definitionContext extends ParserRuleContext {
		public std::string funcDefStr;
		public Func_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_definition; }
	 
		public Func_definitionContext() { }
		public void copyFrom(Func_definitionContext ctx) {
			super.copyFrom(ctx);
			this.funcDefStr = ctx.funcDefStr;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FUNC_DEF_WITH_PARAM_LISTContext extends Func_definitionContext {
		public Type_specifierContext ts;
		public Token ID;
		public Parameter_listContext pl;
		public Compound_statementContext compStmt;
		public TerminalNode ID() { return getToken(C2105055Parser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(C2105055Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(C2105055Parser.RPAREN, 0); }
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public FUNC_DEF_WITH_PARAM_LISTContext(Func_definitionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FUNC_DEF_WITHOUT_PARAM_LISTContext extends Func_definitionContext {
		public Type_specifierContext ts;
		public Token ID;
		public Compound_statementContext compStmt;
		public TerminalNode ID() { return getToken(C2105055Parser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(C2105055Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(C2105055Parser.RPAREN, 0); }
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public FUNC_DEF_WITHOUT_PARAM_LISTContext(Func_definitionContext ctx) { copyFrom(ctx); }
	}

	public final Func_definitionContext func_definition() throws RecognitionException {
		Func_definitionContext _localctx = new Func_definitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_func_definition);
		try {
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new FUNC_DEF_WITH_PARAM_LISTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{

				            SymbolInfo* func = nullptr;
				            bool willShowDeclarationError = false;
				        
				setState(116);
				((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).ts = type_specifier();
				setState(117);
				((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).ID = match(ID);

				            func = symbolTable->lookUp(((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).ID->getText());
				            // funcRetType = ((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).ts.type;
				            retTypeStack.push(((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).ts.type);

				            if (!func)
				            {
				                symbolTable->insert(((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).ID->getText(), "ID");
				                func = symbolTable->lookUp(((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).ID->getText());
				                currentFunction = ((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).ID->getText();
				                func->interpretedType = ((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).ts.type;
				                funcRetType = func->interpretedType;

				            }
				            else
				            {
				                if ((func->isFunction && func->definedFunction)
				                   || (func->isFunction == false))
				                {
				                    // logError(_input->LT(-1)->getLine(), "Multiple declaration of " + ((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).ID->getText());
				                    // semanticErrorCount++;
				                    willShowDeclarationError = true;
				                }
				            }
				            
				            symbolTable->enterScope();
				            insideNewScope = true; 

				            

				            
				        
				setState(119);
				match(LPAREN);
				setState(120);
				((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).pl = parameter_list(0);
				setState(121);
				match(RPAREN);

				            if(willShowDeclarationError)
				            {
				                logError(_input->LT(-1)->getLine(), "Multiple declaration of " + ((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).ID->getText());
				                semanticErrorCount++;
				            }
				            // func->setFunctionDefined();
				            // func = symbolTable->lookUp(((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).ID->getText());
				            bool willSetDefined = true;
				            // if ((func->isFunction && func->definedFunction) || (func->isFunction == false))
				            // {
				            //     willSetDefined = false;
				            //     logError(_input->LT(-1)->getLine(), "Multiple definition of " + ((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).ID->getText());
				            //     semanticErrorCount++;
				            // }
				            // else 
				            if (func->isFunction && !func->definedFunction)
				            {
				                if (funcRetType != ((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).ts.type)
				                {
				                    willSetDefined = false;
				                    cout << "func type check: " << funcRetType << " " << ((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).ts.type << endl;
				                    logError(_input->LT(-1)->getLine(), "Return type mismatch of " + ((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).ID->getText());
				                    semanticErrorCount++;
				                }
				                else if (func->parameters.size() != ((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).pl.paramList.get_variables().size())
				                {
				                    funcRetType = func->interpretedType;


				                    willSetDefined = false;
				                    cout << "WTFF" << endl;
				                    for(int i = 0; i < func->parameters.size(); ++i)
				                    {
				                        cout << func->parameters[i].first << " " << func->parameters[i].second << endl;
				                    }
				                    // cout << func->parameters[i].first
				                     cout << " " << ((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).pl.paramList.get_list_as_string() << endl;
				                    logError(_input->LT(-1)->getLine(), "Total number of arguments mismatch with declaration in function " + ((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).ID->getText());
				                    semanticErrorCount++;
				                }
				                else
				                {
				                    funcRetType = func->interpretedType;
				                    for (size_t i = 0; i < func->parameters.size(); ++i) {
				                        if (func->parameters[i].second != ((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).pl.typeList.get_variables()[i]) {
				                            willSetDefined = false;
				                            logError(_input->LT(-1)->getLine(), to_string(i+1) + "th argument type mismatch with declaration in function " + ((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).ID->getText());
				                            semanticErrorCount++;
				                            break;
				                        }

				                    }
				                }
				            }
				            if(willSetDefined) 
				            {
				                func->makeFunctionSymbol(funcRetType, ((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).pl.typeList.get_variables(), ((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).pl.paramList.get_variables());
				            }
				                func->setFunctionDefined(); // why are we letting wrong functions still be called defined tho?

				            // symbolTable->enterScope();
				            // insideNewScope = true; 

				            // insertFunctionParam(_input->LT(-1)->getLine(), ((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).pl.paramList, ((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).pl.typeList);
				        
				setState(123);
				((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).compStmt = compound_statement();

				            ((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).funcDefStr =  ((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).ts.type + " " + ((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).ID->getText() + "(" + ((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).pl.paramListStr.get_list_as_string() + ")" + ((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).compStmt.compoundStmtStr;
				            
				            retTypeStack.pop();

				            if(((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).compStmt.compoundStmtStr.find("return") != std::string::npos)
				            {
				                if(((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).ts.type == "void")
				                {
				                    logError(_input->LT(-1)->getLine(), "Cannot return value from function " + currentFunction + " with void return type");
				                    semanticErrorCount++;
				                }
				            }

				            logSSA(_input->LT(-1)->getLine(), "func_definition : type_specifier ID LPAREN parameter_list RPAREN compound_statement",
				            _localctx.funcDefStr);

				            // if(!((FUNC_DEF_WITH_PARAM_LISTContext)_localctx).pl.err)
				            // {
				            // logSSA(_input->LT(-1)->getLine(), "func_definition : type_specifier ID LPAREN parameter_list RPAREN compound_statement",
				            // _localctx.funcDefStr);
				            // }
				            // else
				            // {
				            //     logSSA(_input->LT(-1)->getLine(), "func_definition : type_specifier ID LPAREN RPAREN compound_statement",
				            //     _localctx.funcDefStr);   
				            // }     


				        
				}
				break;
			case 2:
				_localctx = new FUNC_DEF_WITHOUT_PARAM_LISTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				((FUNC_DEF_WITHOUT_PARAM_LISTContext)_localctx).ts = type_specifier();
				setState(127);
				((FUNC_DEF_WITHOUT_PARAM_LISTContext)_localctx).ID = match(ID);
				setState(128);
				match(LPAREN);

				            bool success = symbolTable->insert(((FUNC_DEF_WITHOUT_PARAM_LISTContext)_localctx).ID->getText(), "ID");
				            cout << success << " " << ((FUNC_DEF_WITHOUT_PARAM_LISTContext)_localctx).ID->getText() << endl;

				            retTypeStack.push(((FUNC_DEF_WITHOUT_PARAM_LISTContext)_localctx).ts.type);
				            
				            if(success == false)
				            {
				                funcRetType = ((FUNC_DEF_WITHOUT_PARAM_LISTContext)_localctx).ts.type;     
				                SymbolInfo* func = symbolTable->lookUp(((FUNC_DEF_WITHOUT_PARAM_LISTContext)_localctx).ID->getText());
				                // cout << "touche?" << endl;
				                if(func)
				                {
				                    if(func->isFunction && func->definedFunction)
				                    {
				                        logError(_input->LT(-1)->getLine(), "Multiple declaration of " + ((FUNC_DEF_WITHOUT_PARAM_LISTContext)_localctx).ID->getText());
				                        semanticErrorCount++;
				                    }
				                }
				            }
				            else
				            {
				                SymbolInfo* func = symbolTable->lookUp(((FUNC_DEF_WITHOUT_PARAM_LISTContext)_localctx).ID->getText());
				                func->makeFunctionSymbol(((FUNC_DEF_WITHOUT_PARAM_LISTContext)_localctx).ts.type, {}, {});
				                func->setFunctionDefined();
				                currentFunction = ((FUNC_DEF_WITHOUT_PARAM_LISTContext)_localctx).ID->getText();
				            }

				            

				        
				setState(130);
				match(RPAREN);

				                        
				            symbolTable->enterScope();
				            insideNewScope = true; 
				        
				setState(132);
				((FUNC_DEF_WITHOUT_PARAM_LISTContext)_localctx).compStmt = compound_statement();

				            ((FUNC_DEF_WITHOUT_PARAM_LISTContext)_localctx).funcDefStr =  ((FUNC_DEF_WITHOUT_PARAM_LISTContext)_localctx).ts.type + " " + ((FUNC_DEF_WITHOUT_PARAM_LISTContext)_localctx).ID->getText() + "()" + ((FUNC_DEF_WITHOUT_PARAM_LISTContext)_localctx).compStmt.compoundStmtStr;

				            retTypeStack.pop();
				            
				            if(((FUNC_DEF_WITHOUT_PARAM_LISTContext)_localctx).compStmt.compoundStmtStr.find("return") != std::string::npos)
				            {
				                if(((FUNC_DEF_WITHOUT_PARAM_LISTContext)_localctx).ts.type == "void")
				                {
				                    logError(_input->LT(-1)->getLine(), "Cannot return value from function " + currentFunction + " with void return type");
				                    semanticErrorCount++;
				                }
				            }

				            logSSA(_input->LT(-1)->getLine(), "func_definition : type_specifier ID LPAREN RPAREN compound_statement", _localctx.funcDefStr);


				            
				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Parameter_listContext extends ParserRuleContext {
		public str_list paramListStr;
		public str_list paramList;
		public str_list typeList;
		public bool err;
		public Parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_list; }
	 
		public Parameter_listContext() { }
		public void copyFrom(Parameter_listContext ctx) {
			super.copyFrom(ctx);
			this.paramListStr = ctx.paramListStr;
			this.paramList = ctx.paramList;
			this.typeList = ctx.typeList;
			this.err = ctx.err;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIER_IDContext extends Parameter_listContext {
		public Parameter_listContext pl;
		public Type_specifierContext ts;
		public Token ID;
		public TerminalNode COMMA() { return getToken(C2105055Parser.COMMA, 0); }
		public TerminalNode ID() { return getToken(C2105055Parser.ID, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIER_IDContext(Parameter_listContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIERContext extends Parameter_listContext {
		public Parameter_listContext pl;
		public Type_specifierContext ts;
		public TerminalNode COMMA() { return getToken(C2105055Parser.COMMA, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIERContext(Parameter_listContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PARAMLIST_TYPE_SPECIFIERContext extends Parameter_listContext {
		public Type_specifierContext ts;
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public PARAMLIST_TYPE_SPECIFIERContext(Parameter_listContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PARAMLIST_errorContext extends Parameter_listContext {
		public Parameter_listContext pl;
		public TerminalNode ADDOP() { return getToken(C2105055Parser.ADDOP, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public PARAMLIST_errorContext(Parameter_listContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PARAMLIST_TYPE_SPECIFIER_IDContext extends Parameter_listContext {
		public Type_specifierContext ts;
		public Token ID;
		public TerminalNode ID() { return getToken(C2105055Parser.ID, 0); }
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public PARAMLIST_TYPE_SPECIFIER_IDContext(Parameter_listContext ctx) { copyFrom(ctx); }
	}

	public final Parameter_listContext parameter_list() throws RecognitionException {
		return parameter_list(0);
	}

	private Parameter_listContext parameter_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Parameter_listContext _localctx = new Parameter_listContext(_ctx, _parentState);
		Parameter_listContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_parameter_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new PARAMLIST_TYPE_SPECIFIER_IDContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(138);
				((PARAMLIST_TYPE_SPECIFIER_IDContext)_localctx).ts = type_specifier();
				setState(139);
				((PARAMLIST_TYPE_SPECIFIER_IDContext)_localctx).ID = match(ID);

				                _localctx.paramList.set_variables({((PARAMLIST_TYPE_SPECIFIER_IDContext)_localctx).ID->getText()});
				                _localctx.paramListStr.add(((PARAMLIST_TYPE_SPECIFIER_IDContext)_localctx).ts.type + " " + ((PARAMLIST_TYPE_SPECIFIER_IDContext)_localctx).ID->getText());

				                _localctx.typeList.add(((PARAMLIST_TYPE_SPECIFIER_IDContext)_localctx).ts.type);

				                if(insideNewScope)
				                {
				                    if (!symbolTable->insert(((PARAMLIST_TYPE_SPECIFIER_IDContext)_localctx).ID->getText(), "ID")) {
				                        logError(_input->LT(-1)->getLine(), "Multiple declaration of " + ((PARAMLIST_TYPE_SPECIFIER_IDContext)_localctx).ID->getText() + " in parameter");
				                        semanticErrorCount++;
				                    }
				                    else {
				                        SymbolInfo* var = symbolTable->lookUp(((PARAMLIST_TYPE_SPECIFIER_IDContext)_localctx).ID->getText());
				                        if(var)
				                        {
				                            var->interpretedType = ((PARAMLIST_TYPE_SPECIFIER_IDContext)_localctx).ts.type;
				                        }
				                    }
				                }

				                ((PARAMLIST_TYPE_SPECIFIER_IDContext)_localctx).err =  false;
				                logSSA(_input->LT(-1)->getLine(), "parameter_list : type_specifier ID",
				                        _localctx.paramListStr.get_list_as_string());
				            
				}
				break;
			case 2:
				{
				_localctx = new PARAMLIST_TYPE_SPECIFIERContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142);
				((PARAMLIST_TYPE_SPECIFIERContext)_localctx).ts = type_specifier();


				                _localctx.paramListStr.add(((PARAMLIST_TYPE_SPECIFIERContext)_localctx).ts.type);
				                _localctx.paramList.add("");
				                _localctx.typeList.add(((PARAMLIST_TYPE_SPECIFIERContext)_localctx).ts.type);

				                cout << _localctx.paramListStr.get_list_as_string() << endl;
				                cout << "paramlist" << _localctx.paramList.get_list_as_string() << endl;
				                cout << _localctx.typeList.get_list_as_string() << endl;
				                ((PARAMLIST_TYPE_SPECIFIERContext)_localctx).err =  false;
				                logSSA(_input->LT(-1)->getLine(), "parameter_list : type_specifier",
				                        _localctx.paramListStr.get_list_as_string());
				            
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(163);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(161);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIER_IDContext(new Parameter_listContext(_parentctx, _parentState));
						((PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIER_IDContext)_localctx).pl = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_parameter_list);
						setState(147);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(148);
						match(COMMA);
						setState(149);
						((PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIER_IDContext)_localctx).ts = type_specifier();
						setState(150);
						((PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIER_IDContext)_localctx).ID = match(ID);

						                          
						                          _localctx.paramList.set_variables(((PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIER_IDContext)_localctx).pl.paramList.get_variables());
						                          _localctx.paramList.add(((PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIER_IDContext)_localctx).ID->getText());

						                          _localctx.paramListStr.set_variables(((PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIER_IDContext)_localctx).pl.paramListStr.get_variables());
						                          _localctx.paramListStr.add(((PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIER_IDContext)_localctx).ts.type + " " + ((PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIER_IDContext)_localctx).ID->getText());

						                          _localctx.typeList.set_variables(((PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIER_IDContext)_localctx).pl.typeList.get_variables());
						                          _localctx.typeList.add(((PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIER_IDContext)_localctx).ts.type);
						                      
						                          if(insideNewScope)
						                          {
						                              if (!symbolTable->insert(((PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIER_IDContext)_localctx).ID->getText(), "ID")) {
						                                  logError(_input->LT(-1)->getLine(), "Multiple declaration of " + ((PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIER_IDContext)_localctx).ID->getText() + " in parameter");
						                                  semanticErrorCount++;
						                              }   
						                              else {
						                                  SymbolInfo* var = symbolTable->lookUp(((PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIER_IDContext)_localctx).ID->getText());
						                                  if(var)
						                                  {
						                                       var->interpretedType = ((PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIER_IDContext)_localctx).ts.type;
						                                  }
						                              }
						                          }
						                          ((PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIER_IDContext)_localctx).err =  false;
						                          logSSA(_input->LT(-1)->getLine(), "parameter_list : parameter_list COMMA type_specifier ID",
						                                  _localctx.paramListStr.get_list_as_string());
						                      
						}
						break;
					case 2:
						{
						_localctx = new PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIERContext(new Parameter_listContext(_parentctx, _parentState));
						((PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIERContext)_localctx).pl = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_parameter_list);
						setState(153);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(154);
						match(COMMA);
						setState(155);
						((PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIERContext)_localctx).ts = type_specifier();

						                          _localctx.paramList.set_variables(((PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIERContext)_localctx).pl.paramList.get_variables());
						                          _localctx.paramListStr.set_variables(((PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIERContext)_localctx).pl.paramListStr.get_variables());

						                          _localctx.paramListStr.add(((PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIERContext)_localctx).ts.type);
						                          _localctx.typeList.set_variables(((PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIERContext)_localctx).pl.typeList.get_variables());
						                          _localctx.typeList.add(((PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIERContext)_localctx).ts.type);
						                          ((PARAMLIST_PARAMLIST_COMMA_TYPE_SPECIFIERContext)_localctx).err =  false;
						                          logSSA(_input->LT(-1)->getLine(), "parameter_list : parameter_list COMMA type_specifier",
						                                  _localctx.paramListStr.get_list_as_string());
						                      
						}
						break;
					case 3:
						{
						_localctx = new PARAMLIST_errorContext(new Parameter_listContext(_parentctx, _parentState));
						((PARAMLIST_errorContext)_localctx).pl = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_parameter_list);
						setState(158);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(159);
						match(ADDOP);

						                          _localctx.paramListStr.set_variables(((PARAMLIST_errorContext)_localctx).pl.paramListStr.get_variables());
						                          _localctx.paramList.set_variables(((PARAMLIST_errorContext)_localctx).pl.paramList.get_variables());
						                          _localctx.typeList.set_variables(((PARAMLIST_errorContext)_localctx).pl.typeList.get_variables());
						                          cout << "err" << endl;
						                          cout << _localctx.paramListStr.get_list_as_string() << endl;
						                          cout << _localctx.paramList.get_list_as_string() << endl;
						                          cout << _localctx.typeList.get_list_as_string() << endl;
						                          logError(_input->LT(-1)->getLine(), "syntax error, unexpected ADDOP, expecting RPAREN or COMMA");
						                          syntaxErrorCount++;
						                          
						                          ((PARAMLIST_errorContext)_localctx).err =  true;
						                          // _localctx.paramListStr.set_variables({});
						                          // _localctx.paramList.set_variables({});
						                          // _localctx.typeList.set_variables({});
						                      
						}
						break;
					}
					} 
				}
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Compound_statementContext extends ParserRuleContext {
		public std::string compoundStmtStr;
		public Compound_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_statement; }
	 
		public Compound_statementContext() { }
		public void copyFrom(Compound_statementContext ctx) {
			super.copyFrom(ctx);
			this.compoundStmtStr = ctx.compoundStmtStr;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class COMPSTMT_STATEMENTSContext extends Compound_statementContext {
		public Token LCURL;
		public StatementsContext multiStmt;
		public Token RCURL;
		public TerminalNode LCURL() { return getToken(C2105055Parser.LCURL, 0); }
		public TerminalNode RCURL() { return getToken(C2105055Parser.RCURL, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public COMPSTMT_STATEMENTSContext(Compound_statementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class COMPSTMT_EMPTYContext extends Compound_statementContext {
		public Token LCURL;
		public Token RCURL;
		public TerminalNode LCURL() { return getToken(C2105055Parser.LCURL, 0); }
		public TerminalNode RCURL() { return getToken(C2105055Parser.RCURL, 0); }
		public COMPSTMT_EMPTYContext(Compound_statementContext ctx) { copyFrom(ctx); }
	}

	public final Compound_statementContext compound_statement() throws RecognitionException {
		Compound_statementContext _localctx = new Compound_statementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_compound_statement);
		try {
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new COMPSTMT_STATEMENTSContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				((COMPSTMT_STATEMENTSContext)_localctx).LCURL = match(LCURL);

				            if(!insideNewScope)
				            {
				                symbolTable->enterScope();
				            } 
				            insideNewScope = false;

				            // symbolTable->enterScope();
				            // insideNewScope = false;

				        
				setState(168);
				((COMPSTMT_STATEMENTSContext)_localctx).multiStmt = statements(0);
				setState(169);
				((COMPSTMT_STATEMENTSContext)_localctx).RCURL = match(RCURL);
				  

				            ((COMPSTMT_STATEMENTSContext)_localctx).compoundStmtStr =  ((COMPSTMT_STATEMENTSContext)_localctx).LCURL->getText()+"\n" + ((COMPSTMT_STATEMENTSContext)_localctx).multiStmt.multiStmtStr + "\n" + ((COMPSTMT_STATEMENTSContext)_localctx).RCURL->getText();
				            logSSA(_input->LT(-1)->getLine(), "compound_statement : LCURL statements RCURL", _localctx.compoundStmtStr);

				            logSSA(symbolTable->getAllScopeTablesString());
				            symbolTable->exitScope();
				            // insideNewScope = false; 
				        
				}
				break;
			case 2:
				_localctx = new COMPSTMT_EMPTYContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				((COMPSTMT_EMPTYContext)_localctx).LCURL = match(LCURL);

				            if(!insideNewScope)
				            {
				                symbolTable->enterScope();
				            }
				            insideNewScope = false;

				             // symbolTable->enterScope(); insideNewScope = false; 
				        
				setState(174);
				((COMPSTMT_EMPTYContext)_localctx).RCURL = match(RCURL);

				            ((COMPSTMT_EMPTYContext)_localctx).compoundStmtStr =  ((COMPSTMT_EMPTYContext)_localctx).LCURL->getText() + ((COMPSTMT_EMPTYContext)_localctx).RCURL->getText();
				            logSSA(_input->LT(-1)->getLine(), "compound_statement : LCURL RCURL", _localctx.compoundStmtStr);

				            logSSA(symbolTable->getAllScopeTablesString());

				            symbolTable->exitScope(); 
				            // insideNewScope = false;

				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Var_declarationContext extends ParserRuleContext {
		public std::string varDecStr;
		public string type;
		public Var_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_declaration; }
	 
		public Var_declarationContext() { }
		public void copyFrom(Var_declarationContext ctx) {
			super.copyFrom(ctx);
			this.varDecStr = ctx.varDecStr;
			this.type = ctx.type;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VARDEC_TYPE_SPECIFIER_SEMICOLONContext extends Var_declarationContext {
		public Type_specifierContext ts;
		public Token sm;
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(C2105055Parser.SEMICOLON, 0); }
		public VARDEC_TYPE_SPECIFIER_SEMICOLONContext(Var_declarationContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VARDEC_STRUCT_ID_DECLARATION_LIST_SEMICOLONContext extends Var_declarationContext {
		public Token struct_type_name;
		public Declaration_listContext dl;
		public Token sm;
		public TerminalNode STRUCT() { return getToken(C2105055Parser.STRUCT, 0); }
		public TerminalNode ID() { return getToken(C2105055Parser.ID, 0); }
		public Declaration_listContext declaration_list() {
			return getRuleContext(Declaration_listContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(C2105055Parser.SEMICOLON, 0); }
		public VARDEC_STRUCT_ID_DECLARATION_LIST_SEMICOLONContext(Var_declarationContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VARDEC_TYPE_SPECIFIER_DECLARATION_LIST_SEMICOLONContext extends Var_declarationContext {
		public Type_specifierContext t;
		public Declaration_listContext dl;
		public Token sm;
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Declaration_listContext declaration_list() {
			return getRuleContext(Declaration_listContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(C2105055Parser.SEMICOLON, 0); }
		public VARDEC_TYPE_SPECIFIER_DECLARATION_LIST_SEMICOLONContext(Var_declarationContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VARDEC_TYPE_SPECIFIER_ID_ASSIGNOP_LOGIC_EXPRESSION_SEMICOLONContext extends Var_declarationContext {
		public Type_specifierContext ts;
		public Token ID;
		public Logic_expressionContext logicExpr;
		public TerminalNode ID() { return getToken(C2105055Parser.ID, 0); }
		public TerminalNode ASSIGNOP() { return getToken(C2105055Parser.ASSIGNOP, 0); }
		public TerminalNode SEMICOLON() { return getToken(C2105055Parser.SEMICOLON, 0); }
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public VARDEC_TYPE_SPECIFIER_ID_ASSIGNOP_LOGIC_EXPRESSION_SEMICOLONContext(Var_declarationContext ctx) { copyFrom(ctx); }
	}

	public final Var_declarationContext var_declaration() throws RecognitionException {
		Var_declarationContext _localctx = new Var_declarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_var_declaration);
		try {
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new VARDEC_TYPE_SPECIFIER_DECLARATION_LIST_SEMICOLONContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				((VARDEC_TYPE_SPECIFIER_DECLARATION_LIST_SEMICOLONContext)_localctx).t = type_specifier();
				setState(179);
				((VARDEC_TYPE_SPECIFIER_DECLARATION_LIST_SEMICOLONContext)_localctx).dl = declaration_list(0);
				setState(180);
				((VARDEC_TYPE_SPECIFIER_DECLARATION_LIST_SEMICOLONContext)_localctx).sm = match(SEMICOLON);

				            // writeIntoparserLogFile(
				            //     std::string("Variable Declaration: type_specifier declaration_list ") +
				            //     std::to_string(((VARDEC_TYPE_SPECIFIER_DECLARATION_LIST_SEMICOLONContext)_localctx).sm->getType()) +
				            //     " at line " + std::to_string(((VARDEC_TYPE_SPECIFIER_DECLARATION_LIST_SEMICOLONContext)_localctx).sm->getLine())
				            // );

				            ((VARDEC_TYPE_SPECIFIER_DECLARATION_LIST_SEMICOLONContext)_localctx).type =  ((VARDEC_TYPE_SPECIFIER_DECLARATION_LIST_SEMICOLONContext)_localctx).t.type;
				            bool errorDisplayType2 = false;

				            if(_localctx.type == "void")
				            {
				                // logError(_input->LT(-1)->getLine(), "Variable type cannot be void");
				                errorDisplayType2 = true;
				                semanticErrorCount++;
				            }

				            SymbolInfo* var = nullptr;
				            vector<string> variables = ((VARDEC_TYPE_SPECIFIER_DECLARATION_LIST_SEMICOLONContext)_localctx).dl.retList.get_variables();
				            for(int i = 0; i < variables.size(); i++)
				            {
				                var = symbolTable->lookUp(variables[i]);
				                if(var)
				                {
				                    var->interpretedType = _localctx.type;
				                }
				            }
				            // for(int i = 0; i < variables.size(); i++)
				            // {
				            //     var = symbolTable->lookUp(variables[i]);
				            //     cout << "Var type updated?? " << var->getSymbolName() << " " << var->interpretedType << endl;
				            // }

				            ((VARDEC_TYPE_SPECIFIER_DECLARATION_LIST_SEMICOLONContext)_localctx).varDecStr =  ((VARDEC_TYPE_SPECIFIER_DECLARATION_LIST_SEMICOLONContext)_localctx).t.type + " " + ((VARDEC_TYPE_SPECIFIER_DECLARATION_LIST_SEMICOLONContext)_localctx).dl.varList.get_list_as_string() + ";";
				            if(errorDisplayType2 == false)
				            {
				                logSSA(((VARDEC_TYPE_SPECIFIER_DECLARATION_LIST_SEMICOLONContext)_localctx).sm->getLine(), "var_declaration : type_specifier declaration_list SEMICOLON", 
				                _localctx.varDecStr);
				            }
				            else
				            {    
				                logAndErrorType2(_input->LT(-1)->getLine(), "var_declaration : type_specifier declaration_list SEMICOLON", "Variable type cannot be void",
				                    _localctx.varDecStr);
				            }
				        
				}
				break;
			case 2:
				_localctx = new VARDEC_TYPE_SPECIFIER_SEMICOLONContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				((VARDEC_TYPE_SPECIFIER_SEMICOLONContext)_localctx).ts = type_specifier();
				setState(184);
				((VARDEC_TYPE_SPECIFIER_SEMICOLONContext)_localctx).sm = match(SEMICOLON);

				            ((VARDEC_TYPE_SPECIFIER_SEMICOLONContext)_localctx).type =  ((VARDEC_TYPE_SPECIFIER_SEMICOLONContext)_localctx).ts.type;
				            ((VARDEC_TYPE_SPECIFIER_SEMICOLONContext)_localctx).varDecStr =  ((VARDEC_TYPE_SPECIFIER_SEMICOLONContext)_localctx).ts.type + ";";
				            bool errorDisplayType2 = false;
				            logAndErrorType2(_input->LT(-1)->getLine(), "var_declaration : type_specifier declaration_list SEMICOLON", "syntax error, unexpected SEMICOLON, expecting declaration_list",
				                _localctx.varDecStr);
				        
				}
				break;
			case 3:
				_localctx = new VARDEC_STRUCT_ID_DECLARATION_LIST_SEMICOLONContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(187);
				match(STRUCT);
				setState(188);
				((VARDEC_STRUCT_ID_DECLARATION_LIST_SEMICOLONContext)_localctx).struct_type_name = match(ID);
				setState(189);
				((VARDEC_STRUCT_ID_DECLARATION_LIST_SEMICOLONContext)_localctx).dl = declaration_list(0);
				setState(190);
				((VARDEC_STRUCT_ID_DECLARATION_LIST_SEMICOLONContext)_localctx).sm = match(SEMICOLON);

				            ((VARDEC_STRUCT_ID_DECLARATION_LIST_SEMICOLONContext)_localctx).varDecStr =  "struct " + (((VARDEC_STRUCT_ID_DECLARATION_LIST_SEMICOLONContext)_localctx).struct_type_name!=null?((VARDEC_STRUCT_ID_DECLARATION_LIST_SEMICOLONContext)_localctx).struct_type_name.getText():null) + " " + ((VARDEC_STRUCT_ID_DECLARATION_LIST_SEMICOLONContext)_localctx).dl.varList.get_list_as_string() + ";";
				            // ((VARDEC_STRUCT_ID_DECLARATION_LIST_SEMICOLONContext)_localctx).type =  "struct " + (((VARDEC_STRUCT_ID_DECLARATION_LIST_SEMICOLONContext)_localctx).ID!=null?((VARDEC_STRUCT_ID_DECLARATION_LIST_SEMICOLONContext)_localctx).ID.getText():null);
				            currentType = _localctx.type;
				            logSSA(_input->LT(-1)->getLine(), "type_specifier : STRUCT ID declaration_list SEMICOLON",
				                     _localctx.varDecStr);
				        
				}
				break;
			case 4:
				_localctx = new VARDEC_TYPE_SPECIFIER_ID_ASSIGNOP_LOGIC_EXPRESSION_SEMICOLONContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(193);
				((VARDEC_TYPE_SPECIFIER_ID_ASSIGNOP_LOGIC_EXPRESSION_SEMICOLONContext)_localctx).ts = type_specifier();
				setState(194);
				((VARDEC_TYPE_SPECIFIER_ID_ASSIGNOP_LOGIC_EXPRESSION_SEMICOLONContext)_localctx).ID = match(ID);
				setState(195);
				match(ASSIGNOP);
				setState(196);
				((VARDEC_TYPE_SPECIFIER_ID_ASSIGNOP_LOGIC_EXPRESSION_SEMICOLONContext)_localctx).logicExpr = logic_expression();
				setState(197);
				match(SEMICOLON);

				            ((VARDEC_TYPE_SPECIFIER_ID_ASSIGNOP_LOGIC_EXPRESSION_SEMICOLONContext)_localctx).type =  ((VARDEC_TYPE_SPECIFIER_ID_ASSIGNOP_LOGIC_EXPRESSION_SEMICOLONContext)_localctx).ts.type;
				            ((VARDEC_TYPE_SPECIFIER_ID_ASSIGNOP_LOGIC_EXPRESSION_SEMICOLONContext)_localctx).varDecStr =  ((VARDEC_TYPE_SPECIFIER_ID_ASSIGNOP_LOGIC_EXPRESSION_SEMICOLONContext)_localctx).ts.type + " " + ((VARDEC_TYPE_SPECIFIER_ID_ASSIGNOP_LOGIC_EXPRESSION_SEMICOLONContext)_localctx).ID->getText() + " = " + ((VARDEC_TYPE_SPECIFIER_ID_ASSIGNOP_LOGIC_EXPRESSION_SEMICOLONContext)_localctx).logicExpr.logicExprStr + ";";
				            bool errorDisplayType2 = false;

				            if(((VARDEC_TYPE_SPECIFIER_ID_ASSIGNOP_LOGIC_EXPRESSION_SEMICOLONContext)_localctx).ts.type == "void")
				            {
				                // logError(_input->LT(-1)->getLine(), "Variable type cannot be void");
				                errorDisplayType2 = true;
				                semanticErrorCount++;
				            }

				            if(!symbolTable->insert(((VARDEC_TYPE_SPECIFIER_ID_ASSIGNOP_LOGIC_EXPRESSION_SEMICOLONContext)_localctx).ID->getText(), "ID"))
				            {
				                logError(_input->LT(-1)->getLine(), "Multiple declaration of " + ((VARDEC_TYPE_SPECIFIER_ID_ASSIGNOP_LOGIC_EXPRESSION_SEMICOLONContext)_localctx).ID->getText());
				                semanticErrorCount++;
				            }
				            else
				            {
				                SymbolInfo* var = symbolTable->lookUp(((VARDEC_TYPE_SPECIFIER_ID_ASSIGNOP_LOGIC_EXPRESSION_SEMICOLONContext)_localctx).ID->getText());
				                if(var)
				                {
				                    var->interpretedType = _localctx.type;
				                    // cout << "$$$$$$$$$ Type: " << _localctx.type << endl;
				                    // cout << "######################Var type updated?? " << var->getSymbolName() << " " << var->interpretedType << endl;
				                }
				            }

				            if(errorDisplayType2 == false)
				            {
				                logSSA(_input->LT(-1)->getLine(), "var_declaration : type_specifier ID ASSIGNOP logic_expression SEMICOLON", 
				                    _localctx.varDecStr);
				            }
				            else
				            {    
				                logAndErrorType2(_input->LT(-1)->getLine(), "var_declaration : type_specifier ID ASSIGNOP logic_expression SEMICOLON", "Variable type cannot be void",
				                    _localctx.varDecStr);
				            }
				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Var_declaration_listContext extends ParserRuleContext {
		public string varDecListStr;
		public Var_declaration_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_declaration_list; }
	 
		public Var_declaration_listContext() { }
		public void copyFrom(Var_declaration_listContext ctx) {
			super.copyFrom(ctx);
			this.varDecListStr = ctx.varDecListStr;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VARDECLIST_VARDECLIST_VARDECContext extends Var_declaration_listContext {
		public Var_declaration_listContext vdl;
		public Var_declarationContext varDec;
		public Var_declaration_listContext var_declaration_list() {
			return getRuleContext(Var_declaration_listContext.class,0);
		}
		public Var_declarationContext var_declaration() {
			return getRuleContext(Var_declarationContext.class,0);
		}
		public VARDECLIST_VARDECLIST_VARDECContext(Var_declaration_listContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VARDECLIST_VARDECContext extends Var_declaration_listContext {
		public Var_declarationContext vd;
		public Var_declarationContext var_declaration() {
			return getRuleContext(Var_declarationContext.class,0);
		}
		public VARDECLIST_VARDECContext(Var_declaration_listContext ctx) { copyFrom(ctx); }
	}

	public final Var_declaration_listContext var_declaration_list() throws RecognitionException {
		return var_declaration_list(0);
	}

	private Var_declaration_listContext var_declaration_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Var_declaration_listContext _localctx = new Var_declaration_listContext(_ctx, _parentState);
		Var_declaration_listContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_var_declaration_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new VARDECLIST_VARDECContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(203);
			((VARDECLIST_VARDECContext)_localctx).vd = var_declaration();

			            ((VARDECLIST_VARDECContext)_localctx).varDecListStr =  ((VARDECLIST_VARDECContext)_localctx).vd.varDecStr;
			            logSSA(_input->LT(-1)->getLine(), "var_declaration_list : var_declaration", _localctx.varDecListStr);
			        
			}
			_ctx.stop = _input.LT(-1);
			setState(212);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new VARDECLIST_VARDECLIST_VARDECContext(new Var_declaration_listContext(_parentctx, _parentState));
					((VARDECLIST_VARDECLIST_VARDECContext)_localctx).vdl = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_var_declaration_list);
					setState(206);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(207);
					((VARDECLIST_VARDECLIST_VARDECContext)_localctx).varDec = var_declaration();

					                      ((VARDECLIST_VARDECLIST_VARDECContext)_localctx).varDecListStr =  ((VARDECLIST_VARDECLIST_VARDECContext)_localctx).vdl.varDecListStr + "\n" + ((VARDECLIST_VARDECLIST_VARDECContext)_localctx).varDec.varDecStr;
					                      logSSA(_input->LT(-1)->getLine(), "var_declaration_list : var_declaration_list var_declaration", _localctx.varDecListStr);
					                  
					}
					} 
				}
				setState(214);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_declarationContext extends ParserRuleContext {
		public std::string structDeclarationStr;
		public Token ID;
		public Var_declaration_listContext vdl;
		public TerminalNode STRUCT() { return getToken(C2105055Parser.STRUCT, 0); }
		public TerminalNode ID() { return getToken(C2105055Parser.ID, 0); }
		public TerminalNode LCURL() { return getToken(C2105055Parser.LCURL, 0); }
		public TerminalNode RCURL() { return getToken(C2105055Parser.RCURL, 0); }
		public TerminalNode SEMICOLON() { return getToken(C2105055Parser.SEMICOLON, 0); }
		public Var_declaration_listContext var_declaration_list() {
			return getRuleContext(Var_declaration_listContext.class,0);
		}
		public Struct_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_declaration; }
	}

	public final Struct_declarationContext struct_declaration() throws RecognitionException {
		Struct_declarationContext _localctx = new Struct_declarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_struct_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(STRUCT);
			setState(216);
			((Struct_declarationContext)_localctx).ID = match(ID);
			setState(217);
			match(LCURL);
			setState(218);
			((Struct_declarationContext)_localctx).vdl = var_declaration_list(0);
			setState(219);
			match(RCURL);
			setState(220);
			match(SEMICOLON);

			            ((Struct_declarationContext)_localctx).structDeclarationStr =  "struct " + ((Struct_declarationContext)_localctx).ID->getText() + " {\n" + ((Struct_declarationContext)_localctx).vdl.varDecListStr + "\n};";
			            logSSA(_input->LT(-1)->getLine(), "struct_declaration : STRUCT ID LCURL var_declaration_list RCURL SEMICOLON", _localctx.structDeclarationStr);
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Declaration_list_errContext extends ParserRuleContext {
		public std::string error_name;
		public Declaration_list_errContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration_list_err; }
	}

	public final Declaration_list_errContext declaration_list_err() throws RecognitionException {
		Declaration_list_errContext _localctx = new Declaration_list_errContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_declaration_list_err);
		try {
			enterOuterAlt(_localctx, 1);
			{

			        ((Declaration_list_errContext)_localctx).error_name =  "Error in declaration list";

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_specifierContext extends ParserRuleContext {
		public std::string name_line;
		public std::string type;
		public Type_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_specifier; }
	 
		public Type_specifierContext() { }
		public void copyFrom(Type_specifierContext ctx) {
			super.copyFrom(ctx);
			this.name_line = ctx.name_line;
			this.type = ctx.type;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TYPE_SPECIFIER_INTContext extends Type_specifierContext {
		public Token INT;
		public TerminalNode INT() { return getToken(C2105055Parser.INT, 0); }
		public TYPE_SPECIFIER_INTContext(Type_specifierContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TYPE_SPECIFIER_FLOATContext extends Type_specifierContext {
		public Token FLOAT;
		public TerminalNode FLOAT() { return getToken(C2105055Parser.FLOAT, 0); }
		public TYPE_SPECIFIER_FLOATContext(Type_specifierContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TYPE_SPECIFIER_VOIDContext extends Type_specifierContext {
		public Token VOID;
		public TerminalNode VOID() { return getToken(C2105055Parser.VOID, 0); }
		public TYPE_SPECIFIER_VOIDContext(Type_specifierContext ctx) { copyFrom(ctx); }
	}

	public final Type_specifierContext type_specifier() throws RecognitionException {
		Type_specifierContext _localctx = new Type_specifierContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_type_specifier);
		try {
			setState(231);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new TYPE_SPECIFIER_INTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(225);
				((TYPE_SPECIFIER_INTContext)_localctx).INT = match(INT);

				            ((TYPE_SPECIFIER_INTContext)_localctx).name_line =  "type: INT at line" + std::to_string(((TYPE_SPECIFIER_INTContext)_localctx).INT->getLine());
				            ((TYPE_SPECIFIER_INTContext)_localctx).type =  "int";
				            currentType = _localctx.type;

				            logSSA(((TYPE_SPECIFIER_INTContext)_localctx).INT->getLine(), "type_specifier : INT",
				                     "int");
				        
				}
				break;
			case FLOAT:
				_localctx = new TYPE_SPECIFIER_FLOATContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(227);
				((TYPE_SPECIFIER_FLOATContext)_localctx).FLOAT = match(FLOAT);

				            ((TYPE_SPECIFIER_FLOATContext)_localctx).name_line =  "type: FLOAT at line" + std::to_string(((TYPE_SPECIFIER_FLOATContext)_localctx).FLOAT->getLine());
				            ((TYPE_SPECIFIER_FLOATContext)_localctx).type =  "float";
				            currentType = _localctx.type;
				            logSSA(((TYPE_SPECIFIER_FLOATContext)_localctx).FLOAT->getLine(), "type_specifier : FLOAT",
				                     "float");
				        
				}
				break;
			case VOID:
				_localctx = new TYPE_SPECIFIER_VOIDContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(229);
				((TYPE_SPECIFIER_VOIDContext)_localctx).VOID = match(VOID);

				            ((TYPE_SPECIFIER_VOIDContext)_localctx).name_line =  "type: VOID at line" + std::to_string(((TYPE_SPECIFIER_VOIDContext)_localctx).VOID->getLine());
				            ((TYPE_SPECIFIER_VOIDContext)_localctx).type =  "void";
				            currentType = _localctx.type;
				            logSSA(((TYPE_SPECIFIER_VOIDContext)_localctx).VOID->getLine(), "type_specifier : VOID",
				                     "void");
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Declaration_listContext extends ParserRuleContext {
		public str_list varList;
		public str_list retList;
		public Declaration_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration_list; }
	 
		public Declaration_listContext() { }
		public void copyFrom(Declaration_listContext ctx) {
			super.copyFrom(ctx);
			this.varList = ctx.varList;
			this.retList = ctx.retList;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DECLIST_errorContext extends Declaration_listContext {
		public Declaration_listContext dl;
		public Token ID;
		public TerminalNode ADDOP() { return getToken(C2105055Parser.ADDOP, 0); }
		public TerminalNode ID() { return getToken(C2105055Parser.ID, 0); }
		public Declaration_listContext declaration_list() {
			return getRuleContext(Declaration_listContext.class,0);
		}
		public DECLIST_errorContext(Declaration_listContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DECLIST_DECLIST_COMMA_ID_LTHIRD_CONST_INT_RTHIRDContext extends Declaration_listContext {
		public Declaration_listContext dl;
		public Token ID;
		public Token CONST_INT;
		public TerminalNode COMMA() { return getToken(C2105055Parser.COMMA, 0); }
		public TerminalNode ID() { return getToken(C2105055Parser.ID, 0); }
		public TerminalNode LTHIRD() { return getToken(C2105055Parser.LTHIRD, 0); }
		public TerminalNode CONST_INT() { return getToken(C2105055Parser.CONST_INT, 0); }
		public TerminalNode RTHIRD() { return getToken(C2105055Parser.RTHIRD, 0); }
		public Declaration_listContext declaration_list() {
			return getRuleContext(Declaration_listContext.class,0);
		}
		public DECLIST_DECLIST_COMMA_ID_LTHIRD_CONST_INT_RTHIRDContext(Declaration_listContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DECLIST_DECLIST_COMMA_IDContext extends Declaration_listContext {
		public Declaration_listContext dl;
		public Token ID;
		public TerminalNode COMMA() { return getToken(C2105055Parser.COMMA, 0); }
		public TerminalNode ID() { return getToken(C2105055Parser.ID, 0); }
		public Declaration_listContext declaration_list() {
			return getRuleContext(Declaration_listContext.class,0);
		}
		public DECLIST_DECLIST_COMMA_IDContext(Declaration_listContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DECLIST_ID_LTHIRD_CONST_INT_RTHIRDContext extends Declaration_listContext {
		public Token ID;
		public Token CONST_INT;
		public TerminalNode ID() { return getToken(C2105055Parser.ID, 0); }
		public TerminalNode LTHIRD() { return getToken(C2105055Parser.LTHIRD, 0); }
		public TerminalNode CONST_INT() { return getToken(C2105055Parser.CONST_INT, 0); }
		public TerminalNode RTHIRD() { return getToken(C2105055Parser.RTHIRD, 0); }
		public DECLIST_ID_LTHIRD_CONST_INT_RTHIRDContext(Declaration_listContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DECLIST_IDContext extends Declaration_listContext {
		public Token ID;
		public TerminalNode ID() { return getToken(C2105055Parser.ID, 0); }
		public DECLIST_IDContext(Declaration_listContext ctx) { copyFrom(ctx); }
	}

	public final Declaration_listContext declaration_list() throws RecognitionException {
		return declaration_list(0);
	}

	private Declaration_listContext declaration_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Declaration_listContext _localctx = new Declaration_listContext(_ctx, _parentState);
		Declaration_listContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_declaration_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				_localctx = new DECLIST_IDContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(234);
				((DECLIST_IDContext)_localctx).ID = match(ID);

				                _localctx.varList.add(((DECLIST_IDContext)_localctx).ID->getText());

				                if (!symbolTable->insert(((DECLIST_IDContext)_localctx).ID->getText(), "ID")) {
				                    logError(_input->LT(-1)->getLine(), "Multiple declaration of " + ((DECLIST_IDContext)_localctx).ID->getText());
				                    semanticErrorCount++;
				                }
				                else
				                {
				                    // SymbolInfo* var = symbolTable->lookUp(((DECLIST_IDContext)_localctx).ID->getText());
				                    cout << "Current type: " << currentType << endl;
				                    // if(var) var->interpretedType = currentType;
				                    _localctx.retList.add(((DECLIST_IDContext)_localctx).ID->getText());
				                }
				                logSSA(((DECLIST_IDContext)_localctx).ID->getLine(), "declaration_list : ID", ((DECLIST_IDContext)_localctx).ID->getText()); 
				            
				}
				break;
			case 2:
				{
				_localctx = new DECLIST_ID_LTHIRD_CONST_INT_RTHIRDContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(236);
				((DECLIST_ID_LTHIRD_CONST_INT_RTHIRDContext)_localctx).ID = match(ID);
				setState(237);
				match(LTHIRD);
				setState(238);
				((DECLIST_ID_LTHIRD_CONST_INT_RTHIRDContext)_localctx).CONST_INT = match(CONST_INT);
				setState(239);
				match(RTHIRD);

				                _localctx.varList.add(((DECLIST_ID_LTHIRD_CONST_INT_RTHIRDContext)_localctx).ID->getText() + "[" + ((DECLIST_ID_LTHIRD_CONST_INT_RTHIRDContext)_localctx).CONST_INT->getText() + "]");

				                // currentType += " array";

				                if(!symbolTable->insert(((DECLIST_ID_LTHIRD_CONST_INT_RTHIRDContext)_localctx).ID->getText(), "ID")) {
				                    logError(_input->LT(-1)->getLine(), "Multiple declaration of " + ((DECLIST_ID_LTHIRD_CONST_INT_RTHIRDContext)_localctx).ID->getText());
				                    semanticErrorCount++;
				                }
				                else
				                {
				                    SymbolInfo* var = symbolTable->lookUp(((DECLIST_ID_LTHIRD_CONST_INT_RTHIRDContext)_localctx).ID->getText());
				                    if(var)
				                    {
				                        var->makeArraySymbol(currentType, stoi(((DECLIST_ID_LTHIRD_CONST_INT_RTHIRDContext)_localctx).CONST_INT->getText()));
				                        _localctx.retList.add(((DECLIST_ID_LTHIRD_CONST_INT_RTHIRDContext)_localctx).ID->getText());
				                    }
				                }
				                logSSA(((DECLIST_ID_LTHIRD_CONST_INT_RTHIRDContext)_localctx).ID->getLine(), "declaration_list : ID LTHIRD CONST_INT RTHIRD", ((DECLIST_ID_LTHIRD_CONST_INT_RTHIRDContext)_localctx).ID->getText() + "[" + ((DECLIST_ID_LTHIRD_CONST_INT_RTHIRDContext)_localctx).CONST_INT->getText() + "]");
				            
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(260);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(258);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new DECLIST_DECLIST_COMMA_IDContext(new Declaration_listContext(_parentctx, _parentState));
						((DECLIST_DECLIST_COMMA_IDContext)_localctx).dl = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_declaration_list);
						setState(243);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(244);
						match(COMMA);
						setState(245);
						((DECLIST_DECLIST_COMMA_IDContext)_localctx).ID = match(ID);

						                          _localctx.varList.set_variables(((DECLIST_DECLIST_COMMA_IDContext)_localctx).dl.varList.get_variables());
						                          _localctx.varList.add(((DECLIST_DECLIST_COMMA_IDContext)_localctx).ID->getText());

						                          _localctx.retList.set_variables(((DECLIST_DECLIST_COMMA_IDContext)_localctx).dl.retList.get_variables());

						                          if (!symbolTable->insert(((DECLIST_DECLIST_COMMA_IDContext)_localctx).ID->getText(), "ID")) {
						                              logError(_input->LT(-1)->getLine(), "Multiple declaration of " + ((DECLIST_DECLIST_COMMA_IDContext)_localctx).ID->getText());
						                              semanticErrorCount++;
						                          }
						                          else {
						                              SymbolInfo* var = symbolTable->lookUp(((DECLIST_DECLIST_COMMA_IDContext)_localctx).ID->getText());
						                              // if(var) var->interpretedType = currentType;
						                              _localctx.retList.add(((DECLIST_DECLIST_COMMA_IDContext)_localctx).ID->getText());
						                          }

						                          logSSA(((DECLIST_DECLIST_COMMA_IDContext)_localctx).ID->getLine(), "declaration_list : declaration_list COMMA ID", _localctx.varList.get_list_as_string());
						                      
						}
						break;
					case 2:
						{
						_localctx = new DECLIST_DECLIST_COMMA_ID_LTHIRD_CONST_INT_RTHIRDContext(new Declaration_listContext(_parentctx, _parentState));
						((DECLIST_DECLIST_COMMA_ID_LTHIRD_CONST_INT_RTHIRDContext)_localctx).dl = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_declaration_list);
						setState(247);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(248);
						match(COMMA);
						setState(249);
						((DECLIST_DECLIST_COMMA_ID_LTHIRD_CONST_INT_RTHIRDContext)_localctx).ID = match(ID);
						setState(250);
						match(LTHIRD);
						setState(251);
						((DECLIST_DECLIST_COMMA_ID_LTHIRD_CONST_INT_RTHIRDContext)_localctx).CONST_INT = match(CONST_INT);
						setState(252);
						match(RTHIRD);

						                          _localctx.varList.set_variables(((DECLIST_DECLIST_COMMA_ID_LTHIRD_CONST_INT_RTHIRDContext)_localctx).dl.varList.get_variables());
						                          _localctx.varList.add(((DECLIST_DECLIST_COMMA_ID_LTHIRD_CONST_INT_RTHIRDContext)_localctx).ID->getText() + "[" + ((DECLIST_DECLIST_COMMA_ID_LTHIRD_CONST_INT_RTHIRDContext)_localctx).CONST_INT->getText() + "]");
						                          cout << "Current type: " << currentType << endl;
						                          _localctx.retList.set_variables(((DECLIST_DECLIST_COMMA_ID_LTHIRD_CONST_INT_RTHIRDContext)_localctx).dl.retList.get_variables());

						                          // currentType += " array";

						                          if(!symbolTable->insert(((DECLIST_DECLIST_COMMA_ID_LTHIRD_CONST_INT_RTHIRDContext)_localctx).ID->getText(), "ID")) {
						                              logError(_input->LT(-1)->getLine(), "Multiple declaration of " + ((DECLIST_DECLIST_COMMA_ID_LTHIRD_CONST_INT_RTHIRDContext)_localctx).ID->getText());
						                              semanticErrorCount++;
						                          }
						                          else
						                          {
						                              SymbolInfo* var = symbolTable->lookUp(((DECLIST_DECLIST_COMMA_ID_LTHIRD_CONST_INT_RTHIRDContext)_localctx).ID->getText());
						                              if(var)
						                              {
						                                  var->makeArraySymbol(currentType, stoi(((DECLIST_DECLIST_COMMA_ID_LTHIRD_CONST_INT_RTHIRDContext)_localctx).CONST_INT->getText()));
						                                  // var->interpretedType = currentType;
						                                  _localctx.retList.add(((DECLIST_DECLIST_COMMA_ID_LTHIRD_CONST_INT_RTHIRDContext)_localctx).ID->getText());
						                              }
						                          }
						                          logSSA(((DECLIST_DECLIST_COMMA_ID_LTHIRD_CONST_INT_RTHIRDContext)_localctx).ID->getLine(), "declaration_list : declaration_list COMMA ID LTHIRD CONST_INT RTHIRD", _localctx.varList.get_list_as_string());
						                      
						}
						break;
					case 3:
						{
						_localctx = new DECLIST_errorContext(new Declaration_listContext(_parentctx, _parentState));
						((DECLIST_errorContext)_localctx).dl = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_declaration_list);
						setState(254);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(255);
						match(ADDOP);
						setState(256);
						((DECLIST_errorContext)_localctx).ID = match(ID);

						                          logError(_input->LT(-1)->getLine(), "syntax error, unexpected ADDOP, expecting COMMA or SEMICOLON");
						                          syntaxErrorCount++;

						                          _localctx.varList.set_variables(((DECLIST_errorContext)_localctx).dl.varList.get_variables());
						                          _localctx.retList.set_variables(((DECLIST_errorContext)_localctx).dl.retList.get_variables());

						                          // _localctx.varList.set_variables({});
						                          // _localctx.retList.set_variables({});
						                      
						}
						break;
					}
					} 
				}
				setState(262);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public std::string multiStmtStr;
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
	 
		public StatementsContext() { }
		public void copyFrom(StatementsContext ctx) {
			super.copyFrom(ctx);
			this.multiStmtStr = ctx.multiStmtStr;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class STATEMENTS_SINGLE_STATEMENTContext extends StatementsContext {
		public StatementContext singleStatement;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public STATEMENTS_SINGLE_STATEMENTContext(StatementsContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class STATEMENTS_MULTI_STATEMENT_SINGLE_STATEMENTContext extends StatementsContext {
		public StatementsContext multiStmt;
		public StatementContext singleStmt;
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public STATEMENTS_MULTI_STATEMENT_SINGLE_STATEMENTContext(StatementsContext ctx) { copyFrom(ctx); }
	}

	public final StatementsContext statements() throws RecognitionException {
		return statements(0);
	}

	private StatementsContext statements(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatementsContext _localctx = new StatementsContext(_ctx, _parentState);
		StatementsContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_statements, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new STATEMENTS_SINGLE_STATEMENTContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(264);
			((STATEMENTS_SINGLE_STATEMENTContext)_localctx).singleStatement = statement();

			            ((STATEMENTS_SINGLE_STATEMENTContext)_localctx).multiStmtStr =  ((STATEMENTS_SINGLE_STATEMENTContext)_localctx).singleStatement.stmtStr;
			            if(_localctx.multiStmtStr!="")
			                logSSA(_input->LT(-1)->getLine(), "statements : statement", _localctx.multiStmtStr);
			        
			}
			_ctx.stop = _input.LT(-1);
			setState(273);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new STATEMENTS_MULTI_STATEMENT_SINGLE_STATEMENTContext(new StatementsContext(_parentctx, _parentState));
					((STATEMENTS_MULTI_STATEMENT_SINGLE_STATEMENTContext)_localctx).multiStmt = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_statements);
					setState(267);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(268);
					((STATEMENTS_MULTI_STATEMENT_SINGLE_STATEMENTContext)_localctx).singleStmt = statement();

					                      ((STATEMENTS_MULTI_STATEMENT_SINGLE_STATEMENTContext)_localctx).multiStmtStr =  ((STATEMENTS_MULTI_STATEMENT_SINGLE_STATEMENTContext)_localctx).multiStmt.multiStmtStr;
					                      if(((STATEMENTS_MULTI_STATEMENT_SINGLE_STATEMENTContext)_localctx).singleStmt.stmtStr != "") 
					                          _localctx.multiStmtStr += "\n" + ((STATEMENTS_MULTI_STATEMENT_SINGLE_STATEMENTContext)_localctx).singleStmt.stmtStr;
					                      else
					                          _localctx.multiStmtStr += ((STATEMENTS_MULTI_STATEMENT_SINGLE_STATEMENTContext)_localctx).singleStmt.stmtStr;

					                      if(_localctx.multiStmtStr != "" && ((STATEMENTS_MULTI_STATEMENT_SINGLE_STATEMENTContext)_localctx).singleStmt.stmtStr != "")
					                          logSSA(_input->LT(-1)->getLine(), "statements : statements statement", _localctx.multiStmtStr);
					                      
					                  
					}
					} 
				}
				setState(275);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Switch_caseContext extends ParserRuleContext {
		public string switchStr;
		public Switch_statementContext swtchStmt;
		public Default_case_statementContext defaultCaseStmt;
		public TerminalNode SWITCH() { return getToken(C2105055Parser.SWITCH, 0); }
		public TerminalNode LPAREN() { return getToken(C2105055Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(C2105055Parser.RPAREN, 0); }
		public TerminalNode LCURL() { return getToken(C2105055Parser.LCURL, 0); }
		public TerminalNode RCURL() { return getToken(C2105055Parser.RCURL, 0); }
		public Switch_statementContext switch_statement() {
			return getRuleContext(Switch_statementContext.class,0);
		}
		public Default_case_statementContext default_case_statement() {
			return getRuleContext(Default_case_statementContext.class,0);
		}
		public Switch_caseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_case; }
	}

	public final Switch_caseContext switch_case() throws RecognitionException {
		Switch_caseContext _localctx = new Switch_caseContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_switch_case);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(SWITCH);
			setState(277);
			match(LPAREN);
			setState(278);
			expression(0);
			setState(279);
			match(RPAREN);
			setState(280);
			match(LCURL);
			setState(281);
			((Switch_caseContext)_localctx).swtchStmt = switch_statement();
			setState(282);
			((Switch_caseContext)_localctx).defaultCaseStmt = default_case_statement();
			setState(283);
			match(RCURL);

			        logSSA(_input->LT(-1)->getLine(), "switch_case: switch (expression) { switch_statement default_case_statement }", _localctx->getText());
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Do_whileContext extends ParserRuleContext {
		public string doWhileStr;
		public Compound_statementContext compStmt;
		public ExpressionContext expr;
		public TerminalNode DO() { return getToken(C2105055Parser.DO, 0); }
		public TerminalNode WHILE() { return getToken(C2105055Parser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(C2105055Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(C2105055Parser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(C2105055Parser.SEMICOLON, 0); }
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Do_whileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_do_while; }
	}

	public final Do_whileContext do_while() throws RecognitionException {
		Do_whileContext _localctx = new Do_whileContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_do_while);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(DO);

			        insideLoop = true;
			        loopNestingLevel++;
			    
			setState(288);
			((Do_whileContext)_localctx).compStmt = compound_statement();
			setState(289);
			match(WHILE);
			setState(290);
			match(LPAREN);
			setState(291);
			((Do_whileContext)_localctx).expr = expression(0);
			setState(292);
			match(RPAREN);
			setState(293);
			match(SEMICOLON);

			        insideLoop = false;
			        loopNestingLevel--;
			        if(loopNestingLevel < 0)
			        {
			            loopNestingLevel = 0;
			        }
			        ((Do_whileContext)_localctx).doWhileStr =  "do " + ((Do_whileContext)_localctx).compStmt.compoundStmtStr + " while (" + ((Do_whileContext)_localctx).expr.exprStr + ");";
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public std::string stmtStr;
		public string label;
		public string ifLabel;
		public string elseLabel;
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
			this.stmtStr = ctx.stmtStr;
			this.label = ctx.label;
			this.ifLabel = ctx.ifLabel;
			this.elseLabel = ctx.elseLabel;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class STATEMENT_IF_ELSEContext extends StatementContext {
		public Token IF;
		public Token LPAREN;
		public ExpressionContext expr;
		public Token RPAREN;
		public StatementContext stmt1;
		public Token ELSE;
		public StatementContext stmt2;
		public TerminalNode IF() { return getToken(C2105055Parser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(C2105055Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(C2105055Parser.RPAREN, 0); }
		public TerminalNode ELSE() { return getToken(C2105055Parser.ELSE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public STATEMENT_IF_ELSEContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class STATEMENT_PRINTLNContext extends StatementContext {
		public Token PRINTF;
		public Token LPAREN;
		public Token ID;
		public Token RPAREN;
		public TerminalNode PRINTF() { return getToken(C2105055Parser.PRINTF, 0); }
		public TerminalNode LPAREN() { return getToken(C2105055Parser.LPAREN, 0); }
		public TerminalNode ID() { return getToken(C2105055Parser.ID, 0); }
		public TerminalNode RPAREN() { return getToken(C2105055Parser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(C2105055Parser.SEMICOLON, 0); }
		public STATEMENT_PRINTLNContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class STATEMENT_FORContext extends StatementContext {
		public Token FOR;
		public Token LPAREN;
		public Expression_statementContext exprStmt1;
		public Expression_statementContext exprStmt2;
		public ExpressionContext expr;
		public Token RPAREN;
		public StatementContext stmt;
		public TerminalNode FOR() { return getToken(C2105055Parser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(C2105055Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(C2105055Parser.RPAREN, 0); }
		public List<Expression_statementContext> expression_statement() {
			return getRuleContexts(Expression_statementContext.class);
		}
		public Expression_statementContext expression_statement(int i) {
			return getRuleContext(Expression_statementContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public STATEMENT_FORContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class STATEMENT_COMPOUND_STATEMENTContext extends StatementContext {
		public Compound_statementContext compStmt;
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public STATEMENT_COMPOUND_STATEMENTContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class STATEMENT_CONTINUEContext extends StatementContext {
		public Token CONTINUE;
		public TerminalNode CONTINUE() { return getToken(C2105055Parser.CONTINUE, 0); }
		public TerminalNode SEMICOLON() { return getToken(C2105055Parser.SEMICOLON, 0); }
		public STATEMENT_CONTINUEContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class STATEMENT_IFContext extends StatementContext {
		public Token IF;
		public Token LPAREN;
		public ExpressionContext expr;
		public Token RPAREN;
		public StatementContext stmt;
		public TerminalNode IF() { return getToken(C2105055Parser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(C2105055Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(C2105055Parser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public STATEMENT_IFContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class STATEMENT_WHILEContext extends StatementContext {
		public Token WHILE;
		public Token LPAREN;
		public ExpressionContext expr;
		public Token RPAREN;
		public StatementContext stmt;
		public TerminalNode WHILE() { return getToken(C2105055Parser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(C2105055Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(C2105055Parser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public STATEMENT_WHILEContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class STATEMENT_DO_WHILEContext extends StatementContext {
		public Do_whileContext dw;
		public Do_whileContext do_while() {
			return getRuleContext(Do_whileContext.class,0);
		}
		public STATEMENT_DO_WHILEContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class STATEMENT_VAR_DECContext extends StatementContext {
		public Var_declarationContext varDec;
		public Var_declarationContext var_declaration() {
			return getRuleContext(Var_declarationContext.class,0);
		}
		public STATEMENT_VAR_DECContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class STATEMENT_RETURNContext extends StatementContext {
		public Token RETURN;
		public ExpressionContext expr;
		public TerminalNode RETURN() { return getToken(C2105055Parser.RETURN, 0); }
		public TerminalNode SEMICOLON() { return getToken(C2105055Parser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public STATEMENT_RETURNContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class STATEMENT_SWITCH_CASEContext extends StatementContext {
		public Switch_caseContext switch_case() {
			return getRuleContext(Switch_caseContext.class,0);
		}
		public STATEMENT_SWITCH_CASEContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class STATEMENT_EXPRSTMTContext extends StatementContext {
		public Expression_statementContext exprStmt;
		public Expression_statementContext expression_statement() {
			return getRuleContext(Expression_statementContext.class,0);
		}
		public STATEMENT_EXPRSTMTContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class STATEMENT_BREAKContext extends StatementContext {
		public Token BREAK;
		public TerminalNode BREAK() { return getToken(C2105055Parser.BREAK, 0); }
		public TerminalNode SEMICOLON() { return getToken(C2105055Parser.SEMICOLON, 0); }
		public STATEMENT_BREAKContext(StatementContext ctx) { copyFrom(ctx); }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_statement);
		try {
			setState(362);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new STATEMENT_VAR_DECContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				((STATEMENT_VAR_DECContext)_localctx).varDec = var_declaration();

				            ((STATEMENT_VAR_DECContext)_localctx).stmtStr =  ((STATEMENT_VAR_DECContext)_localctx).varDec.varDecStr;
				            logSSA(_input->LT(-1)->getLine(), "statement : var_declaration", _localctx.stmtStr);
				        
				}
				break;
			case 2:
				_localctx = new STATEMENT_EXPRSTMTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(299);
				((STATEMENT_EXPRSTMTContext)_localctx).exprStmt = expression_statement();

				            ((STATEMENT_EXPRSTMTContext)_localctx).stmtStr =  ((STATEMENT_EXPRSTMTContext)_localctx).exprStmt.exprStmtStr;
				            if(((STATEMENT_EXPRSTMTContext)_localctx).exprStmt.exprStmtStr != "")
				                logSSA(_input->LT(-1)->getLine(), "statement : expression_statement", _localctx.stmtStr);
				        
				}
				break;
			case 3:
				_localctx = new STATEMENT_COMPOUND_STATEMENTContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(302);
				((STATEMENT_COMPOUND_STATEMENTContext)_localctx).compStmt = compound_statement();

				            ((STATEMENT_COMPOUND_STATEMENTContext)_localctx).stmtStr =  ((STATEMENT_COMPOUND_STATEMENTContext)_localctx).compStmt.compoundStmtStr;
				            logSSA(_input->LT(-1)->getLine(), "statement : compound_statement", _localctx.stmtStr);
				        
				}
				break;
			case 4:
				_localctx = new STATEMENT_FORContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(305);
				((STATEMENT_FORContext)_localctx).FOR = match(FOR);
				setState(306);
				((STATEMENT_FORContext)_localctx).LPAREN = match(LPAREN);
				setState(307);
				((STATEMENT_FORContext)_localctx).exprStmt1 = expression_statement();
				setState(308);
				((STATEMENT_FORContext)_localctx).exprStmt2 = expression_statement();
				setState(309);
				((STATEMENT_FORContext)_localctx).expr = expression(0);
				setState(310);
				((STATEMENT_FORContext)_localctx).RPAREN = match(RPAREN);

				            insideLoop = true;
				            loopNestingLevel++;
				        
				setState(312);
				((STATEMENT_FORContext)_localctx).stmt = statement();

				            insideLoop = false;
				            loopNestingLevel--;
				            cout << "#######Loop nesting level: " << loopNestingLevel << endl;
				            if(loopNestingLevel < 0)
				            {
				                loopNestingLevel = 0;
				            }
				            ((STATEMENT_FORContext)_localctx).stmtStr =  ((STATEMENT_FORContext)_localctx).FOR->getText() + ((STATEMENT_FORContext)_localctx).LPAREN->getText() + ((STATEMENT_FORContext)_localctx).exprStmt1.exprStmtStr + ((STATEMENT_FORContext)_localctx).exprStmt2.exprStmtStr + ((STATEMENT_FORContext)_localctx).expr.exprStr + ((STATEMENT_FORContext)_localctx).RPAREN->getText() + ((STATEMENT_FORContext)_localctx).stmt.stmtStr;
				            logSSA(_input->LT(-1)->getLine(), "statement : FOR LPAREN expression_statement expression_statement expression RPAREN statement", _localctx.stmtStr);
				        
				}
				break;
			case 5:
				_localctx = new STATEMENT_IFContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(315);
				((STATEMENT_IFContext)_localctx).IF = match(IF);
				setState(316);
				((STATEMENT_IFContext)_localctx).LPAREN = match(LPAREN);
				setState(317);
				((STATEMENT_IFContext)_localctx).expr = expression(0);
				setState(318);
				((STATEMENT_IFContext)_localctx).RPAREN = match(RPAREN);
				setState(319);
				((STATEMENT_IFContext)_localctx).stmt = statement();

				            ((STATEMENT_IFContext)_localctx).stmtStr =  ((STATEMENT_IFContext)_localctx).IF->getText() + ((STATEMENT_IFContext)_localctx).LPAREN->getText() + ((STATEMENT_IFContext)_localctx).expr.exprStr + ((STATEMENT_IFContext)_localctx).RPAREN->getText() + ((STATEMENT_IFContext)_localctx).stmt.stmtStr;
				            logSSA(_input->LT(-1)->getLine(), "statement : IF LPAREN expression RPAREN statement", _localctx.stmtStr);
				        
				}
				break;
			case 6:
				_localctx = new STATEMENT_IF_ELSEContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(322);
				((STATEMENT_IF_ELSEContext)_localctx).IF = match(IF);
				setState(323);
				((STATEMENT_IF_ELSEContext)_localctx).LPAREN = match(LPAREN);
				setState(324);
				((STATEMENT_IF_ELSEContext)_localctx).expr = expression(0);
				setState(325);
				((STATEMENT_IF_ELSEContext)_localctx).RPAREN = match(RPAREN);
				setState(326);
				((STATEMENT_IF_ELSEContext)_localctx).stmt1 = statement();
				setState(327);
				((STATEMENT_IF_ELSEContext)_localctx).ELSE = match(ELSE);
				setState(328);
				((STATEMENT_IF_ELSEContext)_localctx).stmt2 = statement();

				            ((STATEMENT_IF_ELSEContext)_localctx).stmtStr =  ((STATEMENT_IF_ELSEContext)_localctx).IF->getText() + ((STATEMENT_IF_ELSEContext)_localctx).LPAREN->getText() + ((STATEMENT_IF_ELSEContext)_localctx).expr.exprStr + ((STATEMENT_IF_ELSEContext)_localctx).RPAREN->getText() + ((STATEMENT_IF_ELSEContext)_localctx).stmt1.stmtStr + ((STATEMENT_IF_ELSEContext)_localctx).ELSE->getText() + " " + ((STATEMENT_IF_ELSEContext)_localctx).stmt2.stmtStr;
				            logSSA(_input->LT(-1)->getLine(), "statement : IF LPAREN expression RPAREN statement ELSE statement", _localctx.stmtStr);
				        
				}
				break;
			case 7:
				_localctx = new STATEMENT_WHILEContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(331);
				((STATEMENT_WHILEContext)_localctx).WHILE = match(WHILE);

				            insideLoop = true;
				            loopNestingLevel++;
				        
				setState(333);
				((STATEMENT_WHILEContext)_localctx).LPAREN = match(LPAREN);
				setState(334);
				((STATEMENT_WHILEContext)_localctx).expr = expression(0);
				setState(335);
				((STATEMENT_WHILEContext)_localctx).RPAREN = match(RPAREN);
				setState(336);
				((STATEMENT_WHILEContext)_localctx).stmt = statement();

				            insideLoop = false;
				            loopNestingLevel--;
				            cout << "#####Loop nesting level: " << loopNestingLevel << endl;
				            if(loopNestingLevel < 0)
				            {
				                loopNestingLevel = 0;
				            }
				            ((STATEMENT_WHILEContext)_localctx).stmtStr =  ((STATEMENT_WHILEContext)_localctx).WHILE->getText() + ((STATEMENT_WHILEContext)_localctx).LPAREN->getText() + ((STATEMENT_WHILEContext)_localctx).expr.exprStr + ((STATEMENT_WHILEContext)_localctx).RPAREN->getText() + ((STATEMENT_WHILEContext)_localctx).stmt.stmtStr;
				            logSSA(_input->LT(-1)->getLine(), "statement : WHILE LPAREN expression RPAREN statement", _localctx.stmtStr);
				        
				}
				break;
			case 8:
				_localctx = new STATEMENT_PRINTLNContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(339);
				((STATEMENT_PRINTLNContext)_localctx).PRINTF = match(PRINTF);
				setState(340);
				((STATEMENT_PRINTLNContext)_localctx).LPAREN = match(LPAREN);
				setState(341);
				((STATEMENT_PRINTLNContext)_localctx).ID = match(ID);
				setState(342);
				((STATEMENT_PRINTLNContext)_localctx).RPAREN = match(RPAREN);
				setState(343);
				match(SEMICOLON);

				            ((STATEMENT_PRINTLNContext)_localctx).stmtStr =  ((STATEMENT_PRINTLNContext)_localctx).PRINTF->getText() + " " + ((STATEMENT_PRINTLNContext)_localctx).LPAREN->getText() + ((STATEMENT_PRINTLNContext)_localctx).ID->getText() + ((STATEMENT_PRINTLNContext)_localctx).RPAREN->getText() + ";";
				            logSSA(_input->LT(-1)->getLine(), "statement : PRINTLN LPAREN ID RPAREN SEMICOLON", _localctx.stmtStr);

				        
				}
				break;
			case 9:
				_localctx = new STATEMENT_RETURNContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(345);
				((STATEMENT_RETURNContext)_localctx).RETURN = match(RETURN);
				setState(346);
				((STATEMENT_RETURNContext)_localctx).expr = expression(0);
				setState(347);
				match(SEMICOLON);

				            ((STATEMENT_RETURNContext)_localctx).stmtStr =  ((STATEMENT_RETURNContext)_localctx).RETURN->getText() + " " + ((STATEMENT_RETURNContext)_localctx).expr.exprStr + ";";
				            string currRetType = retTypeStack.top();

				            // if(funcRetType != "void" && funcRetType != ((STATEMENT_RETURNContext)_localctx).expr.type)
				            if(currRetType != "void" && currRetType != ((STATEMENT_RETURNContext)_localctx).expr.type)
				            {
				                logError(_input->LT(-1)->getLine(), "Return type mismatch of " + currentFunction);
				                semanticErrorCount++;
				            }
				            if (funcRetType == "void")
				            {
				                // logError(_input->LT(-1)->getLine(), "Cannot return value from function " + currentFunction + " with void return type");
				                // semanticErrorCount++;
				            }
				            logSSA(_input->LT(-1)->getLine(), "statement : RETURN expression SEMICOLON", _localctx.stmtStr);
				        
				}
				break;
			case 10:
				_localctx = new STATEMENT_SWITCH_CASEContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(350);
				switch_case();
				logSSA(_input->LT(-1)->getLine(), "switch_case" , _localctx->getText()) ;
				}
				break;
			case 11:
				_localctx = new STATEMENT_BREAKContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(353);
				((STATEMENT_BREAKContext)_localctx).BREAK = match(BREAK);
				setState(354);
				match(SEMICOLON);

				            ((STATEMENT_BREAKContext)_localctx).stmtStr =  ((STATEMENT_BREAKContext)_localctx).BREAK->getText() + ";";
				            logSSA(_input->LT(-1)->getLine(), "statement: BREAK SEMICOLON", _localctx.stmtStr);
				            
				            // does not work for nested loops
				            // if(insideLoop == false)
				            //     logError(_input->LT(-1)->getLine(), "break outside loop or switch statement");

				            if(loopNestingLevel == 0)
				            {
				                logError(_input->LT(-1)->getLine(), "break outside loop or switch statement");
				                semanticErrorCount++;
				            }


				        
				}
				break;
			case 12:
				_localctx = new STATEMENT_CONTINUEContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(356);
				((STATEMENT_CONTINUEContext)_localctx).CONTINUE = match(CONTINUE);
				setState(357);
				match(SEMICOLON);

				            ((STATEMENT_CONTINUEContext)_localctx).stmtStr =  ((STATEMENT_CONTINUEContext)_localctx).CONTINUE->getText() + ";";
				            logSSA(_input->LT(-1)->getLine(), "statement: CONTINUE SEMICOLON", _localctx.stmtStr);
				            
				            // does not work for nested loops
				            // if(insideLoop == false)
				            //     logError(_input->LT(-1)->getLine(), "continue outside loop");

				            if(loopNestingLevel == 0)
				            {
				                logError(_input->LT(-1)->getLine(), "continue outside loop");
				                semanticErrorCount++;
				            }
				        
				}
				break;
			case 13:
				_localctx = new STATEMENT_DO_WHILEContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(359);
				((STATEMENT_DO_WHILEContext)_localctx).dw = do_while();

				            ((STATEMENT_DO_WHILEContext)_localctx).stmtStr =  ((STATEMENT_DO_WHILEContext)_localctx).dw.doWhileStr;
				            logSSA(_input->LT(-1)->getLine(), "statement: do_while" , ((STATEMENT_DO_WHILEContext)_localctx).dw.doWhileStr) ;
				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Const_newContext extends ParserRuleContext {
		public string constStr;
		public Const_newContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_new; }
	 
		public Const_newContext() { }
		public void copyFrom(Const_newContext ctx) {
			super.copyFrom(ctx);
			this.constStr = ctx.constStr;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CONSTNEW_CONST_FLOATContext extends Const_newContext {
		public Token CONST_FLOAT;
		public TerminalNode CONST_FLOAT() { return getToken(C2105055Parser.CONST_FLOAT, 0); }
		public CONSTNEW_CONST_FLOATContext(Const_newContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CONSTNEW_CONST_INTContext extends Const_newContext {
		public Token CONST_INT;
		public TerminalNode CONST_INT() { return getToken(C2105055Parser.CONST_INT, 0); }
		public CONSTNEW_CONST_INTContext(Const_newContext ctx) { copyFrom(ctx); }
	}

	public final Const_newContext const_new() throws RecognitionException {
		Const_newContext _localctx = new Const_newContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_const_new);
		try {
			setState(368);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST_INT:
				_localctx = new CONSTNEW_CONST_INTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(364);
				((CONSTNEW_CONST_INTContext)_localctx).CONST_INT = match(CONST_INT);
				 ((CONSTNEW_CONST_INTContext)_localctx).constStr =  ((CONSTNEW_CONST_INTContext)_localctx).CONST_INT->getText(); logSSA(_input->LT(-1)->getLine(), "const_new : CONST_INT", _localctx.constStr); 
				}
				break;
			case CONST_FLOAT:
				_localctx = new CONSTNEW_CONST_FLOATContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(366);
				((CONSTNEW_CONST_FLOATContext)_localctx).CONST_FLOAT = match(CONST_FLOAT);
				 ((CONSTNEW_CONST_FLOATContext)_localctx).constStr =  ((CONSTNEW_CONST_FLOATContext)_localctx).CONST_FLOAT->getText(); logSSA(_input->LT(-1)->getLine(), "const_new : CONST_FLOAT", _localctx.constStr); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Switch_statementContext extends ParserRuleContext {
		public string stmrStr;
		public Switch_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_statement; }
	 
		public Switch_statementContext() { }
		public void copyFrom(Switch_statementContext ctx) {
			super.copyFrom(ctx);
			this.stmrStr = ctx.stmrStr;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SWITCHSTATEMENT_CASE_STATEMENT_SWITCHSTATEMENTContext extends Switch_statementContext {
		public Case_statementContext case_statement() {
			return getRuleContext(Case_statementContext.class,0);
		}
		public Switch_statementContext switch_statement() {
			return getRuleContext(Switch_statementContext.class,0);
		}
		public SWITCHSTATEMENT_CASE_STATEMENT_SWITCHSTATEMENTContext(Switch_statementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SWITCHSTATEMENT_CASE_STATEMENTContext extends Switch_statementContext {
		public Case_statementContext caseStmt;
		public Case_statementContext case_statement() {
			return getRuleContext(Case_statementContext.class,0);
		}
		public SWITCHSTATEMENT_CASE_STATEMENTContext(Switch_statementContext ctx) { copyFrom(ctx); }
	}

	public final Switch_statementContext switch_statement() throws RecognitionException {
		Switch_statementContext _localctx = new Switch_statementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_switch_statement);
		try {
			setState(377);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new SWITCHSTATEMENT_CASE_STATEMENTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(370);
				((SWITCHSTATEMENT_CASE_STATEMENTContext)_localctx).caseStmt = case_statement();

				        logSSA(_input->LT(-1)->getLine(), "switch_statement: case_statement", ((SWITCHSTATEMENT_CASE_STATEMENTContext)_localctx).caseStmt.stmtStr);
				    
				}
				break;
			case 2:
				_localctx = new SWITCHSTATEMENT_CASE_STATEMENT_SWITCHSTATEMENTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(373);
				case_statement();
				setState(374);
				switch_statement();

				        logSSA(_input->LT(-1)->getLine(), "switch_statement: case_statement switch_statement", _localctx->getText());
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Case_statementContext extends ParserRuleContext {
		public string stmtStr;
		public Const_newContext const_;
		public Token colon;
		public StatementsContext multiStmt;
		public Token BREAK;
		public TerminalNode CASE() { return getToken(C2105055Parser.CASE, 0); }
		public TerminalNode BREAK() { return getToken(C2105055Parser.BREAK, 0); }
		public TerminalNode SEMICOLON() { return getToken(C2105055Parser.SEMICOLON, 0); }
		public Const_newContext const_new() {
			return getRuleContext(Const_newContext.class,0);
		}
		public TerminalNode COLON() { return getToken(C2105055Parser.COLON, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public Case_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_statement; }
	}

	public final Case_statementContext case_statement() throws RecognitionException {
		Case_statementContext _localctx = new Case_statementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_case_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			match(CASE);
			setState(380);
			((Case_statementContext)_localctx).const_ = const_new();
			setState(381);
			((Case_statementContext)_localctx).colon = match(COLON);
			setState(382);
			((Case_statementContext)_localctx).multiStmt = statements(0);
			setState(383);
			((Case_statementContext)_localctx).BREAK = match(BREAK);
			setState(384);
			match(SEMICOLON);

			        // ((Case_statementContext)_localctx).stmtStr =  ((Case_statementContext)_localctx).const.constStr + " " + ((Case_statementContext)_localctx).colon->getText() + " " + ((Case_statementContext)_localctx).multiStmt.multiStmtStr + ((Case_statementContext)_localctx).BREAK->getText() + ";";
			        logSSA(_input->LT(-1)->getLine(), "case_statement: CASE CONST COLON statements BREAK SEMICOLON", _localctx.stmtStr);
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Default_case_statementContext extends ParserRuleContext {
		public string stmtStr;
		public TerminalNode DEFAULT() { return getToken(C2105055Parser.DEFAULT, 0); }
		public TerminalNode COLON() { return getToken(C2105055Parser.COLON, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode BREAK() { return getToken(C2105055Parser.BREAK, 0); }
		public TerminalNode SEMICOLON() { return getToken(C2105055Parser.SEMICOLON, 0); }
		public Default_case_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_default_case_statement; }
	}

	public final Default_case_statementContext default_case_statement() throws RecognitionException {
		Default_case_statementContext _localctx = new Default_case_statementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_default_case_statement);
		try {
			setState(395);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DEFAULT:
				enterOuterAlt(_localctx, 1);
				{
				setState(387);
				match(DEFAULT);
				setState(388);
				match(COLON);
				setState(389);
				statements(0);
				setState(390);
				match(BREAK);
				setState(391);
				match(SEMICOLON);

				        logSSA(_input->LT(-1)->getLine(), "default_statement", _localctx->getText());
				    
				}
				break;
			case RCURL:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expression_statementContext extends ParserRuleContext {
		public std::string exprStmtStr;
		public Expression_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_statement; }
	 
		public Expression_statementContext() { }
		public void copyFrom(Expression_statementContext ctx) {
			super.copyFrom(ctx);
			this.exprStmtStr = ctx.exprStmtStr;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EXPRSTMT_SEMICOLONContext extends Expression_statementContext {
		public Token SEMICOLON;
		public TerminalNode SEMICOLON() { return getToken(C2105055Parser.SEMICOLON, 0); }
		public EXPRSTMT_SEMICOLONContext(Expression_statementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EXPRSTMT_EXPRESSION_SEMICOLONContext extends Expression_statementContext {
		public ExpressionContext expr;
		public TerminalNode SEMICOLON() { return getToken(C2105055Parser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EXPRSTMT_EXPRESSION_SEMICOLONContext(Expression_statementContext ctx) { copyFrom(ctx); }
	}

	public final Expression_statementContext expression_statement() throws RecognitionException {
		Expression_statementContext _localctx = new Expression_statementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expression_statement);
		try {
			setState(403);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMICOLON:
				_localctx = new EXPRSTMT_SEMICOLONContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(397);
				((EXPRSTMT_SEMICOLONContext)_localctx).SEMICOLON = match(SEMICOLON);

				                ((EXPRSTMT_SEMICOLONContext)_localctx).exprStmtStr =  ((EXPRSTMT_SEMICOLONContext)_localctx).SEMICOLON->getText();
				                logSSA(_input->LT(-1)->getLine(), "expression_statement : SEMICOLON", _localctx.exprStmtStr);
				            
				}
				break;
			case LPAREN:
			case ADDOP:
			case NOT:
			case ASSIGNOP:
			case ID:
			case CONST_INT:
			case CONST_FLOAT:
				_localctx = new EXPRSTMT_EXPRESSION_SEMICOLONContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(399);
				((EXPRSTMT_EXPRESSION_SEMICOLONContext)_localctx).expr = expression(0);
				setState(400);
				match(SEMICOLON);

				                if(((EXPRSTMT_EXPRESSION_SEMICOLONContext)_localctx).expr.exprStr != "")
				                {
				                    ((EXPRSTMT_EXPRESSION_SEMICOLONContext)_localctx).exprStmtStr =  ((EXPRSTMT_EXPRESSION_SEMICOLONContext)_localctx).expr.exprStr + ";";
				                    logSSA(_input->LT(-1)->getLine(), "expression_statement : expression SEMICOLON", _localctx.exprStmtStr);
				                }
				                else
				                {
				                    ((EXPRSTMT_EXPRESSION_SEMICOLONContext)_localctx).exprStmtStr =  ((EXPRSTMT_EXPRESSION_SEMICOLONContext)_localctx).expr.exprStr;
				                }
				            
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends ParserRuleContext {
		public std::string varExpr;
		public string type;
		public string varName;
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
	 
		public VariableContext() { }
		public void copyFrom(VariableContext ctx) {
			super.copyFrom(ctx);
			this.varExpr = ctx.varExpr;
			this.type = ctx.type;
			this.varName = ctx.varName;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VARIABLE_IDContext extends VariableContext {
		public Token ID;
		public TerminalNode ID() { return getToken(C2105055Parser.ID, 0); }
		public VARIABLE_IDContext(VariableContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VARIABLE_ID_LTHIRD_EXPRESSION_RTHIRDContext extends VariableContext {
		public Token ID;
		public ExpressionContext expr;
		public TerminalNode ID() { return getToken(C2105055Parser.ID, 0); }
		public TerminalNode LTHIRD() { return getToken(C2105055Parser.LTHIRD, 0); }
		public TerminalNode RTHIRD() { return getToken(C2105055Parser.RTHIRD, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VARIABLE_ID_LTHIRD_EXPRESSION_RTHIRDContext(VariableContext ctx) { copyFrom(ctx); }
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_variable);
		try {
			setState(413);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new VARIABLE_IDContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(405);
				((VARIABLE_IDContext)_localctx).ID = match(ID);

				            ((VARIABLE_IDContext)_localctx).varExpr =  ((VARIABLE_IDContext)_localctx).ID->getText();
				            ((VARIABLE_IDContext)_localctx).varName =  ((VARIABLE_IDContext)_localctx).ID->getText();

				            SymbolInfo* var = symbolTable->lookUp(((VARIABLE_IDContext)_localctx).ID->getText());
				            bool errorDisplayType2 = false;
				            if(var)
				            {
				                ((VARIABLE_IDContext)_localctx).type =  var->interpretedType;
				                cout << "Line (INSIDE VARIABLE: ID ): " << _input->LT(-1)->getLine() << " variable "<< _localctx.varExpr << " type: " << _localctx.type << endl;
				                if(var->isArray)
				                { 
				                    // logError(_input->LT(-1)->getLine(), "Type mismatch, " + ((VARIABLE_IDContext)_localctx).ID->getText() + " is an array"); 
				                    logAndErrorType2(_input->LT(-1)->getLine(), "variable : ID", "Type mismatch, " + ((VARIABLE_IDContext)_localctx).ID->getText() + " is an array", _localctx.varExpr);
				                    semanticErrorCount++; 
				                    errorDisplayType2 = true;
				                }

				                else if (var->isFunction) { logError(_input->LT(-1)->getLine(), "Type mismatch, " + ((VARIABLE_IDContext)_localctx).ID->getText() + " is a function"); semanticErrorCount++;}
				                // else if(funcRetType != _localctx.type && funcRetType != "void")
				                // {
				                //     logError(_input->LT(-1)->getLine(), "Return type mismatch of " + currentFunction);
				                //     semanticErrorCount++;
				                // }
				            }
				            else
				            {
				                // logError(_input->LT(-1)->getLine(), "Undeclared variable " + ((VARIABLE_IDContext)_localctx).ID->getText());
				                logAndErrorType2(_input->LT(-1)->getLine(), "variable : ID", "Undeclared variable " + ((VARIABLE_IDContext)_localctx).ID->getText(), _localctx.varExpr);
				                errorDisplayType2 = true;
				                semanticErrorCount++;
				                ((VARIABLE_IDContext)_localctx).type =  "undeclared";
				            }

				            if(errorDisplayType2 == false)
				            { logSSA(_input->LT(-1)->getLine(), "variable : ID", _localctx.varExpr); }
				        
				}
				break;
			case 2:
				_localctx = new VARIABLE_ID_LTHIRD_EXPRESSION_RTHIRDContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(407);
				((VARIABLE_ID_LTHIRD_EXPRESSION_RTHIRDContext)_localctx).ID = match(ID);
				setState(408);
				match(LTHIRD);
				setState(409);
				((VARIABLE_ID_LTHIRD_EXPRESSION_RTHIRDContext)_localctx).expr = expression(0);
				setState(410);
				match(RTHIRD);

				            ((VARIABLE_ID_LTHIRD_EXPRESSION_RTHIRDContext)_localctx).varName =  ((VARIABLE_ID_LTHIRD_EXPRESSION_RTHIRDContext)_localctx).ID->getText();
				            ((VARIABLE_ID_LTHIRD_EXPRESSION_RTHIRDContext)_localctx).varExpr =  ((VARIABLE_ID_LTHIRD_EXPRESSION_RTHIRDContext)_localctx).ID->getText() + "[" + ((VARIABLE_ID_LTHIRD_EXPRESSION_RTHIRDContext)_localctx).expr.exprStr + "]";

				            SymbolInfo* var = symbolTable->lookUp(((VARIABLE_ID_LTHIRD_EXPRESSION_RTHIRDContext)_localctx).ID->getText());
				            bool errorDisplayType2 = false;
				            if(var)
				            {
				                cout << ((VARIABLE_ID_LTHIRD_EXPRESSION_RTHIRDContext)_localctx).ID->getText() << " " << var->isArray << " is the isArray value" << endl;
				                if(((VARIABLE_ID_LTHIRD_EXPRESSION_RTHIRDContext)_localctx).expr.type != "int")
				                {
				                    // logError(_input->LT(-1)->getLine(), "Expression inside third brackets not an integer");
				                    errorDisplayType2 = true;
				                    logAndErrorType2(_input->LT(-1)->getLine(), "variable : ID LTHIRD expression RTHIRD", "Expression inside third brackets not an integer", _localctx.varExpr);
				                    semanticErrorCount++;
				                }
				                ((VARIABLE_ID_LTHIRD_EXPRESSION_RTHIRDContext)_localctx).type =  var->interpretedType;

				                if(funcRetType != _localctx.type && funcRetType != "void")
				                {
				                    logError(_input->LT(-1)->getLine(), "Return type mismatch of " + currentFunction);
				                    semanticErrorCount++;
				                }

				                if (var->isArray == false)
				                {
				                    // logError(_input->LT(-1)->getLine(), ((VARIABLE_ID_LTHIRD_EXPRESSION_RTHIRDContext)_localctx).ID->getText() + " not an array");
				                    errorDisplayType2 = true;
				                    logAndErrorType2(_input->LT(-1)->getLine(), "variable : ID LTHIRD expression RTHIRD", ((VARIABLE_ID_LTHIRD_EXPRESSION_RTHIRDContext)_localctx).ID->getText() + " not an array", _localctx.varExpr);
				                    semanticErrorCount++;
				                }
				            }
				            
				            else
				            {
				                logError(_input->LT(-1)->getLine(), "Undeclared variable " + ((VARIABLE_ID_LTHIRD_EXPRESSION_RTHIRDContext)_localctx).ID->getText());
				                semanticErrorCount++;
				                ((VARIABLE_ID_LTHIRD_EXPRESSION_RTHIRDContext)_localctx).type =  "undeclared";
				            }

				            if(!errorDisplayType2)
				                logSSA(_input->LT(-1)->getLine(), "variable : ID LTHIRD expression RTHIRD", _localctx.varExpr);
				            
				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public std::string exprStr;
		public string type;
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
			this.exprStr = ctx.exprStr;
			this.type = ctx.type;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EXPRESSION_LOGIC_EXPRESSIONContext extends ExpressionContext {
		public Logic_expressionContext logicExpr;
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public EXPRESSION_LOGIC_EXPRESSIONContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext extends ExpressionContext {
		public VariableContext var;
		public Token ASSIGNOP;
		public ExpressionContext expr;
		public TerminalNode ASSIGNOP() { return getToken(C2105055Parser.ASSIGNOP, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext extends ExpressionContext {
		public VariableContext var;
		public Token ASSIGNOP;
		public Logic_expressionContext logicExpr;
		public TerminalNode ASSIGNOP() { return getToken(C2105055Parser.ASSIGNOP, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EXPRESSION_EXPRESSION_UNRECOGNIZED_CHARContext extends ExpressionContext {
		public ExpressionContext expr;
		public Token UNRECOGNIZED_CHAR;
		public TerminalNode UNRECOGNIZED_CHAR() { return getToken(C2105055Parser.UNRECOGNIZED_CHAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EXPRESSION_EXPRESSION_UNRECOGNIZED_CHARContext(ExpressionContext ctx) { copyFrom(ctx); }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(429);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				_localctx = new EXPRESSION_LOGIC_EXPRESSIONContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(416);
				((EXPRESSION_LOGIC_EXPRESSIONContext)_localctx).logicExpr = logic_expression();

				            ((EXPRESSION_LOGIC_EXPRESSIONContext)_localctx).exprStr =  ((EXPRESSION_LOGIC_EXPRESSIONContext)_localctx).logicExpr.logicExprStr;
				            ((EXPRESSION_LOGIC_EXPRESSIONContext)_localctx).type =  ((EXPRESSION_LOGIC_EXPRESSIONContext)_localctx).logicExpr.type;
				            logSSA(_input->LT(-1)->getLine(), "expression : logic_expression", _localctx.exprStr);
				        
				}
				break;
			case 2:
				{
				_localctx = new EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(419);
				((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).var = variable();
				setState(420);
				((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).ASSIGNOP = match(ASSIGNOP);
				setState(421);
				((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).logicExpr = logic_expression();

				            ((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).exprStr =  ((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).var.varExpr + ((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).ASSIGNOP->getText() + ((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).logicExpr.logicExprStr;
				            // NOTE
				            // ((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).var.type is useless here
				            // ((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).type =  ((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).var.type;
				            SymbolInfo* varSymbol = symbolTable->lookUp(((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).var.varName);
				            bool varIsArray = false;
				            bool errorDisplayType2 = false;

				            if(varSymbol)
				            {
				                ((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).type =  varSymbol->interpretedType;
				                if (varSymbol->isFunction) 
				                {
				                    logError(_input->LT(-1)->getLine(), "Type mismatch, " + ((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).var.varExpr + " is a function");
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
				                // logError(_input->LT(-1)->getLine(), "Undeclared variable " + ((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).var.varExpr);
				                // semanticErrorCount++;
				                ((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).type =  "undeclared";
				            }
				            
				            cout << "Line (INSIDE VARIABLE: ASSIGNOP): " << _input->LT(-1)->getLine() << " variable "<< ((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).var.varExpr << " type: " << _localctx.type << " isArray: " << varIsArray << endl;
				            cout << "Line :" << _input->LT(-1)->getLine() << " variable "<< ((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).var.varExpr << " type: " << _localctx.type << endl;
				            cout << "\t" << " logic expression "<< ((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).logicExpr.logicExprStr << " type: " << ((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).logicExpr.type << endl;

				            // will function similar to xv6. 
				            // currently INT = FLOAT is allowed in C, so is FLOAT = INT
				            // but allowing that will cause mismatch with logs for assignment 3

				            if(_localctx.type != "undeclared" && ((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).logicExpr.type != "undeclared" && ((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).logicExpr.type != "undefined")
				            {
				                if(_localctx.type != ((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).logicExpr.type && ((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).logicExpr.type != "void")
				                {
				                    // if(!((_localctx.type == "int" && (varIsArray == false) && ((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).logicExpr.type == "float") 
				                    //     || (_localctx.type == "float" && ((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).logicExpr.type == "int")))
				                    if(!( (varIsArray == false) && (_localctx.type == "float" && ((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).logicExpr.type == "int")))
				                    {
				                        // logError(_input->LT(-1)->getLine(), "Type Mismatch");

				                        logAndErrorType2(_input->LT(-1)->getLine(), "expression : variable ASSIGNOP logic_expression", "Type Mismatch", _localctx.exprStr);

				                        errorDisplayType2 = true;
				                        semanticErrorCount++;
				                    }
				                }

				                if(((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).logicExpr.type == "void")
				                {
				                    // logError(_input->LT(-1)->getLine(), "Void function used in expression");
				                    logAndErrorType2(_input->LT(-1)->getLine(), "expression : variable ASSIGNOP logic_expression", "Void function used in expression", _localctx.exprStr);
				                    errorDisplayType2 = true;
				                    semanticErrorCount++;
				                }
				            }

				            if(((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).logicExpr.logicExprStr != "")
				            {
				                if(errorDisplayType2 == false) logSSA(_input->LT(-1)->getLine(), "expression : variable ASSIGNOP logic_expression", _localctx.exprStr);
				            }
				            else
				                ((EXPRESSION_VARIABLE_ASSIGNOP_LOGIC_EXPRESSIONContext)_localctx).exprStr =  "";

				        
				}
				break;
			case 3:
				{
				_localctx = new EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(424);
				((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).var = variable();
				setState(425);
				((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).ASSIGNOP = match(ASSIGNOP);
				setState(426);
				((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).expr = expression(2);

				            ((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).exprStr =  ((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).var.varExpr + ((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).ASSIGNOP->getText() + ((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).expr.exprStr;
				            // NOTE
				            // ((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).var.type is useless here
				            // ((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).type =  ((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).var.type;
				            SymbolInfo* varSymbol = symbolTable->lookUp(((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).var.varName);
				            bool varIsArray = false;
				            bool errorDisplayType2 = false;

				            if(varSymbol)
				            {
				                ((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).type =  varSymbol->interpretedType;
				                if (varSymbol->isFunction) 
				                {
				                    logError(_input->LT(-1)->getLine(), "Type mismatch, " + ((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).var.varExpr + " is a function");
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
				                // logError(_input->LT(-1)->getLine(), "Undeclared variable " + ((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).var.varExpr);
				                // semanticErrorCount++;
				                ((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).type =  "undeclared";
				            }
				            
				            cout << "Line (INSIDE VARIABLE: ASSIGNOP): " << _input->LT(-1)->getLine() << " variable "<< ((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).var.varExpr << " type: " << _localctx.type << " isArray: " << varIsArray << endl;
				            cout << "Line :" << _input->LT(-1)->getLine() << " variable "<< ((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).var.varExpr << " type: " << _localctx.type << endl;
				            cout << "\t" << " expression "<< ((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).expr.exprStr << " type: " << ((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).expr.type << endl;

				            // will function similar to xv6. 
				            // currently INT = FLOAT is allowed in C, so is FLOAT = INT

				            if(_localctx.type != "undeclared" && ((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).expr.type != "undeclared" && ((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).expr.type != "undefined")
				            {
				                if(_localctx.type != ((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).expr.type && ((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).expr.type != "void")
				                {
				                    // if(!((_localctx.type == "int" && (varIsArray == false) && ((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).expr.type == "float") 
				                    //     || (_localctx.type == "float" && ((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).expr.type == "int")))
				                    if(!( (varIsArray == false) && (_localctx.type == "float" && ((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).expr.type == "int")))
				                    {   
				                        // logError(_input->LT(-1)->getLine(), "Type Mismatch");
				                        logAndErrorType2(_input->LT(-1)->getLine(), "expression : variable ASSIGNOP expression", "Type Mismatch", _localctx.exprStr);
				                        errorDisplayType2 = true;
				                        semanticErrorCount++;
				                    }
				                }
				            }

				            if(((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).expr.type == "void")
				            {
				                // logError(_input->LT(-1)->getLine(), "Void function used in expression");
				                logAndErrorType2(_input->LT(-1)->getLine(), "expression : variable ASSIGNOP expression", "Void function used in expression", _localctx.exprStr);
				                errorDisplayType2 = true;
				                semanticErrorCount++;
				            }

				            if(((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).expr.exprStr != "")
				            {
				                if(errorDisplayType2 == false) logSSA(_input->LT(-1)->getLine(), "expression : variable ASSIGNOP expression", _localctx.exprStr);
				            }
				            else
				            {
				                ((EXPRESSION_VARIABLE_ASSIGNOP_EXPRESSIONContext)_localctx).exprStr =  "";
				            }
				        
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(436);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EXPRESSION_EXPRESSION_UNRECOGNIZED_CHARContext(new ExpressionContext(_parentctx, _parentState));
					((EXPRESSION_EXPRESSION_UNRECOGNIZED_CHARContext)_localctx).expr = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(431);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(432);
					((EXPRESSION_EXPRESSION_UNRECOGNIZED_CHARContext)_localctx).UNRECOGNIZED_CHAR = match(UNRECOGNIZED_CHAR);

					                      logError(_input->LT(-1)->getLine(), "Unrecognized character " + ((EXPRESSION_EXPRESSION_UNRECOGNIZED_CHARContext)_localctx).UNRECOGNIZED_CHAR->getText());
					                      semanticErrorCount++;
					                      ((EXPRESSION_EXPRESSION_UNRECOGNIZED_CHARContext)_localctx).exprStr =  "";
					                      ((EXPRESSION_EXPRESSION_UNRECOGNIZED_CHARContext)_localctx).type =  "error";
					                  
					}
					} 
				}
				setState(438);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Logic_expressionContext extends ParserRuleContext {
		public std::string logicExprStr;
		public string type;
		public string funcNameIfFunction;
		public Logic_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_expression; }
	 
		public Logic_expressionContext() { }
		public void copyFrom(Logic_expressionContext ctx) {
			super.copyFrom(ctx);
			this.logicExprStr = ctx.logicExprStr;
			this.type = ctx.type;
			this.funcNameIfFunction = ctx.funcNameIfFunction;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LOGICEXPRESSION_REL_EXPRESSION_LOGICOP_REL_EXPRESSIONContext extends Logic_expressionContext {
		public Rel_expressionContext relExpr1;
		public Token LOGICOP;
		public Rel_expressionContext relExpr2;
		public TerminalNode LOGICOP() { return getToken(C2105055Parser.LOGICOP, 0); }
		public List<Rel_expressionContext> rel_expression() {
			return getRuleContexts(Rel_expressionContext.class);
		}
		public Rel_expressionContext rel_expression(int i) {
			return getRuleContext(Rel_expressionContext.class,i);
		}
		public LOGICEXPRESSION_REL_EXPRESSION_LOGICOP_REL_EXPRESSIONContext(Logic_expressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LOGICEXPRESSION_REL_EXPRESSIONContext extends Logic_expressionContext {
		public Rel_expressionContext relExpr;
		public Rel_expressionContext rel_expression() {
			return getRuleContext(Rel_expressionContext.class,0);
		}
		public LOGICEXPRESSION_REL_EXPRESSIONContext(Logic_expressionContext ctx) { copyFrom(ctx); }
	}

	public final Logic_expressionContext logic_expression() throws RecognitionException {
		Logic_expressionContext _localctx = new Logic_expressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_logic_expression);
		try {
			setState(447);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				_localctx = new LOGICEXPRESSION_REL_EXPRESSIONContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(439);
				((LOGICEXPRESSION_REL_EXPRESSIONContext)_localctx).relExpr = rel_expression();

				            ((LOGICEXPRESSION_REL_EXPRESSIONContext)_localctx).logicExprStr =  ((LOGICEXPRESSION_REL_EXPRESSIONContext)_localctx).relExpr.relExprStr;
				            ((LOGICEXPRESSION_REL_EXPRESSIONContext)_localctx).type =  ((LOGICEXPRESSION_REL_EXPRESSIONContext)_localctx).relExpr.type;
				            ((LOGICEXPRESSION_REL_EXPRESSIONContext)_localctx).funcNameIfFunction =  ((LOGICEXPRESSION_REL_EXPRESSIONContext)_localctx).relExpr.funcNameIfFunction;
				            cout << "Line: " << _input->LT(-1)->getLine() << " " << _localctx.logicExprStr << " " << ((LOGICEXPRESSION_REL_EXPRESSIONContext)_localctx).relExpr.type << endl;\
				            if(((LOGICEXPRESSION_REL_EXPRESSIONContext)_localctx).relExpr.relExprStr != "")
				                logSSA(_input->LT(-1)->getLine(), "logic_expression : rel_expression", _localctx.logicExprStr);
				        
				}
				break;
			case 2:
				_localctx = new LOGICEXPRESSION_REL_EXPRESSION_LOGICOP_REL_EXPRESSIONContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(442);
				((LOGICEXPRESSION_REL_EXPRESSION_LOGICOP_REL_EXPRESSIONContext)_localctx).relExpr1 = rel_expression();
				setState(443);
				((LOGICEXPRESSION_REL_EXPRESSION_LOGICOP_REL_EXPRESSIONContext)_localctx).LOGICOP = match(LOGICOP);
				setState(444);
				((LOGICEXPRESSION_REL_EXPRESSION_LOGICOP_REL_EXPRESSIONContext)_localctx).relExpr2 = rel_expression();

				            ((LOGICEXPRESSION_REL_EXPRESSION_LOGICOP_REL_EXPRESSIONContext)_localctx).logicExprStr =  ((LOGICEXPRESSION_REL_EXPRESSION_LOGICOP_REL_EXPRESSIONContext)_localctx).relExpr1.relExprStr + ((LOGICEXPRESSION_REL_EXPRESSION_LOGICOP_REL_EXPRESSIONContext)_localctx).LOGICOP->getText() + ((LOGICEXPRESSION_REL_EXPRESSION_LOGICOP_REL_EXPRESSIONContext)_localctx).relExpr2.relExprStr;
				            ((LOGICEXPRESSION_REL_EXPRESSION_LOGICOP_REL_EXPRESSIONContext)_localctx).type =  "int"; // C doesn't technically have bool :3, don't change laterrrr
				            if(((LOGICEXPRESSION_REL_EXPRESSION_LOGICOP_REL_EXPRESSIONContext)_localctx).relExpr1.funcNameIfFunction != "")
				            {
				                // ((LOGICEXPRESSION_REL_EXPRESSION_LOGICOP_REL_EXPRESSIONContext)_localctx).funcNameIfFunction =  ((LOGICEXPRESSION_REL_EXPRESSION_LOGICOP_REL_EXPRESSIONContext)_localctx).relExpr1.funcNameIfFunction;
				                SymbolInfo* func1 = symbolTable->lookUp(((LOGICEXPRESSION_REL_EXPRESSION_LOGICOP_REL_EXPRESSIONContext)_localctx).relExpr1.funcNameIfFunction);

				                if(func1)
				                {
				                    if(func1->isFunction && !func1->definedFunction)
				                    {
				                        logError(_input->LT(-1)->getLine(), "Cannot use function " + ((LOGICEXPRESSION_REL_EXPRESSION_LOGICOP_REL_EXPRESSIONContext)_localctx).relExpr1.funcNameIfFunction + " in expression before definition");
				                        semanticErrorCount++;
				                    }

				                    if(func1->interpretedType == "void")
				                    {
				                        logError(_input->LT(-1)->getLine(), "Void function used in expression");
				                        semanticErrorCount++;
				                    }
				                }
				            }
				            if(((LOGICEXPRESSION_REL_EXPRESSION_LOGICOP_REL_EXPRESSIONContext)_localctx).relExpr2.funcNameIfFunction != "")
				            {
				                SymbolInfo* func2 = symbolTable->lookUp(((LOGICEXPRESSION_REL_EXPRESSION_LOGICOP_REL_EXPRESSIONContext)_localctx).relExpr2.funcNameIfFunction);
				                if(func2)
				                {
				                    if(func2->isFunction && !func2->definedFunction)
				                    {
				                        logError(_input->LT(-1)->getLine(), "Cannot use function " + ((LOGICEXPRESSION_REL_EXPRESSION_LOGICOP_REL_EXPRESSIONContext)_localctx).relExpr2.funcNameIfFunction + " in expression before definition");
				                        semanticErrorCount++;
				                    }

				                    if(func2->interpretedType == "void")
				                    {
				                        logError(_input->LT(-1)->getLine(), "Void function used in expression");
				                        semanticErrorCount++;
				                    }
				                }
				            }
				            logSSA(_input->LT(-1)->getLine(), "logic_expression : rel_expression LOGICOP rel_expression", _localctx.logicExprStr);
				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Rel_expressionContext extends ParserRuleContext {
		public std::string relExprStr;
		public string type;
		public string funcNameIfFunction;
		public Rel_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel_expression; }
	 
		public Rel_expressionContext() { }
		public void copyFrom(Rel_expressionContext ctx) {
			super.copyFrom(ctx);
			this.relExprStr = ctx.relExprStr;
			this.type = ctx.type;
			this.funcNameIfFunction = ctx.funcNameIfFunction;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RELEXPRESSION_SIMPLE_EXPRESSIONContext extends Rel_expressionContext {
		public Simple_expressionContext simpleExpr;
		public Simple_expressionContext simple_expression() {
			return getRuleContext(Simple_expressionContext.class,0);
		}
		public RELEXPRESSION_SIMPLE_EXPRESSIONContext(Rel_expressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RELEXPRESSION_SIMPLE_EXPRESSION_RELOP_SIMPLE_EXPRESSIONContext extends Rel_expressionContext {
		public Simple_expressionContext simpleExpr1;
		public Token RELOP;
		public Simple_expressionContext simpleExpr2;
		public TerminalNode RELOP() { return getToken(C2105055Parser.RELOP, 0); }
		public List<Simple_expressionContext> simple_expression() {
			return getRuleContexts(Simple_expressionContext.class);
		}
		public Simple_expressionContext simple_expression(int i) {
			return getRuleContext(Simple_expressionContext.class,i);
		}
		public RELEXPRESSION_SIMPLE_EXPRESSION_RELOP_SIMPLE_EXPRESSIONContext(Rel_expressionContext ctx) { copyFrom(ctx); }
	}

	public final Rel_expressionContext rel_expression() throws RecognitionException {
		Rel_expressionContext _localctx = new Rel_expressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_rel_expression);
		try {
			setState(457);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				_localctx = new RELEXPRESSION_SIMPLE_EXPRESSIONContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(449);
				((RELEXPRESSION_SIMPLE_EXPRESSIONContext)_localctx).simpleExpr = simple_expression(0);

				            ((RELEXPRESSION_SIMPLE_EXPRESSIONContext)_localctx).relExprStr =  ((RELEXPRESSION_SIMPLE_EXPRESSIONContext)_localctx).simpleExpr.simpleExprStr;
				            if(((RELEXPRESSION_SIMPLE_EXPRESSIONContext)_localctx).simpleExpr.simpleExprStr != "")
				            {
				                logSSA(_input->LT(-1)->getLine(), "rel_expression : simple_expression", _localctx.relExprStr);
				            }
				            ((RELEXPRESSION_SIMPLE_EXPRESSIONContext)_localctx).type =  ((RELEXPRESSION_SIMPLE_EXPRESSIONContext)_localctx).simpleExpr.type;
				            ((RELEXPRESSION_SIMPLE_EXPRESSIONContext)_localctx).funcNameIfFunction =  ((RELEXPRESSION_SIMPLE_EXPRESSIONContext)_localctx).simpleExpr.funcNameIfFunction;
				        
				}
				break;
			case 2:
				_localctx = new RELEXPRESSION_SIMPLE_EXPRESSION_RELOP_SIMPLE_EXPRESSIONContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(452);
				((RELEXPRESSION_SIMPLE_EXPRESSION_RELOP_SIMPLE_EXPRESSIONContext)_localctx).simpleExpr1 = simple_expression(0);
				setState(453);
				((RELEXPRESSION_SIMPLE_EXPRESSION_RELOP_SIMPLE_EXPRESSIONContext)_localctx).RELOP = match(RELOP);
				setState(454);
				((RELEXPRESSION_SIMPLE_EXPRESSION_RELOP_SIMPLE_EXPRESSIONContext)_localctx).simpleExpr2 = simple_expression(0);

				            ((RELEXPRESSION_SIMPLE_EXPRESSION_RELOP_SIMPLE_EXPRESSIONContext)_localctx).relExprStr =  ((RELEXPRESSION_SIMPLE_EXPRESSION_RELOP_SIMPLE_EXPRESSIONContext)_localctx).simpleExpr1.simpleExprStr + ((RELEXPRESSION_SIMPLE_EXPRESSION_RELOP_SIMPLE_EXPRESSIONContext)_localctx).RELOP->getText() + ((RELEXPRESSION_SIMPLE_EXPRESSION_RELOP_SIMPLE_EXPRESSIONContext)_localctx).simpleExpr2.simpleExprStr;
				            ((RELEXPRESSION_SIMPLE_EXPRESSION_RELOP_SIMPLE_EXPRESSIONContext)_localctx).type =  "int"; // C doesn't technically have bool :3, don't change laterrrr

				            if(((RELEXPRESSION_SIMPLE_EXPRESSION_RELOP_SIMPLE_EXPRESSIONContext)_localctx).simpleExpr1.funcNameIfFunction != "")
				            {
				                ((RELEXPRESSION_SIMPLE_EXPRESSION_RELOP_SIMPLE_EXPRESSIONContext)_localctx).funcNameIfFunction =  "FUNCTION"; // non empty only to check later on
				                SymbolInfo* func1 = symbolTable->lookUp(((RELEXPRESSION_SIMPLE_EXPRESSION_RELOP_SIMPLE_EXPRESSIONContext)_localctx).simpleExpr1.funcNameIfFunction);

				                if(func1)
				                {
				                    if(func1->isFunction && !func1->definedFunction)
				                    {
				                        logError(_input->LT(-1)->getLine(), "Cannot use function " + ((RELEXPRESSION_SIMPLE_EXPRESSION_RELOP_SIMPLE_EXPRESSIONContext)_localctx).simpleExpr1.funcNameIfFunction + " in expression before definition");
				                        semanticErrorCount++;
				                    }

				                    if(func1->interpretedType == "void")
				                    {
				                        logError(_input->LT(-1)->getLine(), "Void function used in expression");
				                        semanticErrorCount++;
				                    }
				                }
				            }
				            if(((RELEXPRESSION_SIMPLE_EXPRESSION_RELOP_SIMPLE_EXPRESSIONContext)_localctx).simpleExpr2.funcNameIfFunction != "")
				            {
				                SymbolInfo* func2 = symbolTable->lookUp(((RELEXPRESSION_SIMPLE_EXPRESSION_RELOP_SIMPLE_EXPRESSIONContext)_localctx).simpleExpr2.funcNameIfFunction);
				                ((RELEXPRESSION_SIMPLE_EXPRESSION_RELOP_SIMPLE_EXPRESSIONContext)_localctx).funcNameIfFunction =  "FUNCTION"; // non empty only to check later on
				                if(func2)
				                {
				                    if(func2->isFunction && !func2->definedFunction)
				                    {
				                        logError(_input->LT(-1)->getLine(), "Cannot use function " + ((RELEXPRESSION_SIMPLE_EXPRESSION_RELOP_SIMPLE_EXPRESSIONContext)_localctx).simpleExpr2.funcNameIfFunction + " in expression before definition");
				                        semanticErrorCount++;
				                    }

				                    if(func2->interpretedType == "void")
				                    {
				                        logError(_input->LT(-1)->getLine(), "Void function used in expression");
				                        semanticErrorCount++;
				                    }
				                }
				            }

				                

				            logSSA(_input->LT(-1)->getLine(), "rel_expression : simple_expression RELOP simple_expression", _localctx.relExprStr);
				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Simple_expressionContext extends ParserRuleContext {
		public std::string simpleExprStr;
		public string type;
		public string funcNameIfFunction;
		public Simple_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_expression; }
	 
		public Simple_expressionContext() { }
		public void copyFrom(Simple_expressionContext ctx) {
			super.copyFrom(ctx);
			this.simpleExprStr = ctx.simpleExprStr;
			this.type = ctx.type;
			this.funcNameIfFunction = ctx.funcNameIfFunction;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SIMPLEEXPRESSION_SIMPLE_EXPRESSION_ADDOP_TERMContext extends Simple_expressionContext {
		public Simple_expressionContext simpleExpr;
		public Token ADDOP;
		public TermContext t;
		public TerminalNode ADDOP() { return getToken(C2105055Parser.ADDOP, 0); }
		public Simple_expressionContext simple_expression() {
			return getRuleContext(Simple_expressionContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public SIMPLEEXPRESSION_SIMPLE_EXPRESSION_ADDOP_TERMContext(Simple_expressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SIMPLEEXPRESSION_TERMContext extends Simple_expressionContext {
		public TermContext t;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public SIMPLEEXPRESSION_TERMContext(Simple_expressionContext ctx) { copyFrom(ctx); }
	}

	public final Simple_expressionContext simple_expression() throws RecognitionException {
		return simple_expression(0);
	}

	private Simple_expressionContext simple_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Simple_expressionContext _localctx = new Simple_expressionContext(_ctx, _parentState);
		Simple_expressionContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_simple_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SIMPLEEXPRESSION_TERMContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(460);
			((SIMPLEEXPRESSION_TERMContext)_localctx).t = term(0);

			            ((SIMPLEEXPRESSION_TERMContext)_localctx).simpleExprStr =  ((SIMPLEEXPRESSION_TERMContext)_localctx).t.termStr;
			            
			            ((SIMPLEEXPRESSION_TERMContext)_localctx).type =  ((SIMPLEEXPRESSION_TERMContext)_localctx).t.type;
			            ((SIMPLEEXPRESSION_TERMContext)_localctx).funcNameIfFunction =  ((SIMPLEEXPRESSION_TERMContext)_localctx).t.funcNameIfFunction;
			            logSSA(_input->LT(-1)->getLine(), "simple_expression : term", _localctx.simpleExprStr);
			        
			}
			_ctx.stop = _input.LT(-1);
			setState(470);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SIMPLEEXPRESSION_SIMPLE_EXPRESSION_ADDOP_TERMContext(new Simple_expressionContext(_parentctx, _parentState));
					((SIMPLEEXPRESSION_SIMPLE_EXPRESSION_ADDOP_TERMContext)_localctx).simpleExpr = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_simple_expression);
					setState(463);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(464);
					((SIMPLEEXPRESSION_SIMPLE_EXPRESSION_ADDOP_TERMContext)_localctx).ADDOP = match(ADDOP);
					setState(465);
					((SIMPLEEXPRESSION_SIMPLE_EXPRESSION_ADDOP_TERMContext)_localctx).t = term(0);

					                      cout << "SIMPLEEXPR ADDOP TERM... TERMSTR " << ((SIMPLEEXPRESSION_SIMPLE_EXPRESSION_ADDOP_TERMContext)_localctx).t.termStr << "T_T" << endl;
					                      if(((SIMPLEEXPRESSION_SIMPLE_EXPRESSION_ADDOP_TERMContext)_localctx).t.termStr != "")
					                      {   ((SIMPLEEXPRESSION_SIMPLE_EXPRESSION_ADDOP_TERMContext)_localctx).simpleExprStr =  ((SIMPLEEXPRESSION_SIMPLE_EXPRESSION_ADDOP_TERMContext)_localctx).simpleExpr.simpleExprStr + ((SIMPLEEXPRESSION_SIMPLE_EXPRESSION_ADDOP_TERMContext)_localctx).ADDOP->getText() + ((SIMPLEEXPRESSION_SIMPLE_EXPRESSION_ADDOP_TERMContext)_localctx).t.termStr;
					                          logSSA(_input->LT(-1)->getLine(), "simple_expression : simple_expression ADDOP term", _localctx.simpleExprStr);
					                      }
					                      else
					                      {
					                          ((SIMPLEEXPRESSION_SIMPLE_EXPRESSION_ADDOP_TERMContext)_localctx).simpleExprStr =  "";
					                      }
					                      ((SIMPLEEXPRESSION_SIMPLE_EXPRESSION_ADDOP_TERMContext)_localctx).funcNameIfFunction =  ((SIMPLEEXPRESSION_SIMPLE_EXPRESSION_ADDOP_TERMContext)_localctx).t.funcNameIfFunction;
					                      if(((SIMPLEEXPRESSION_SIMPLE_EXPRESSION_ADDOP_TERMContext)_localctx).simpleExpr.type == "float" || ((SIMPLEEXPRESSION_SIMPLE_EXPRESSION_ADDOP_TERMContext)_localctx).t.type == "float")
					                      {
					                          ((SIMPLEEXPRESSION_SIMPLE_EXPRESSION_ADDOP_TERMContext)_localctx).type =  "float";
					                      }
					                      else { ((SIMPLEEXPRESSION_SIMPLE_EXPRESSION_ADDOP_TERMContext)_localctx).type =  "int"; }

					                  
					}
					} 
				}
				setState(472);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public std::string termStr;
		public string type;
		public string funcNameIfFunction;
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
			this.termStr = ctx.termStr;
			this.type = ctx.type;
			this.funcNameIfFunction = ctx.funcNameIfFunction;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TERM_ASSIGNOPContext extends TermContext {
		public TerminalNode ASSIGNOP() { return getToken(C2105055Parser.ASSIGNOP, 0); }
		public TERM_ASSIGNOPContext(TermContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TERM_TERM_MULOP_UNARY_EXPRESSIONContext extends TermContext {
		public TermContext t;
		public Token MULOP;
		public Unary_expressionContext unaryExpr;
		public TerminalNode MULOP() { return getToken(C2105055Parser.MULOP, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public TERM_TERM_MULOP_UNARY_EXPRESSIONContext(TermContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TERM_UNARY_EXPRESSIONContext extends TermContext {
		public Unary_expressionContext unaryExpr;
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public TERM_UNARY_EXPRESSIONContext(TermContext ctx) { copyFrom(ctx); }
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case ADDOP:
			case NOT:
			case ID:
			case CONST_INT:
			case CONST_FLOAT:
				{
				_localctx = new TERM_UNARY_EXPRESSIONContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(474);
				((TERM_UNARY_EXPRESSIONContext)_localctx).unaryExpr = unary_expression();

				            ((TERM_UNARY_EXPRESSIONContext)_localctx).termStr =  ((TERM_UNARY_EXPRESSIONContext)_localctx).unaryExpr.unaryExprStr;
				            ((TERM_UNARY_EXPRESSIONContext)_localctx).type =  ((TERM_UNARY_EXPRESSIONContext)_localctx).unaryExpr.type;
				            logSSA(_input->LT(-1)->getLine(), "term : unary_expression", _localctx.termStr);
				        
				}
				break;
			case ASSIGNOP:
				{
				_localctx = new TERM_ASSIGNOPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(477);
				match(ASSIGNOP);

				            logError(_input->LT(-1)->getLine(), "syntax error, unexpected ASSIGNOP");
				            syntaxErrorCount++;

				            ((TERM_ASSIGNOPContext)_localctx).termStr =  "";
				            ((TERM_ASSIGNOPContext)_localctx).type =  "";
				            ((TERM_ASSIGNOPContext)_localctx).funcNameIfFunction =  "";
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(488);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TERM_TERM_MULOP_UNARY_EXPRESSIONContext(new TermContext(_parentctx, _parentState));
					((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).t = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_term);
					setState(481);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(482);
					((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).MULOP = match(MULOP);
					setState(483);
					((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).unaryExpr = unary_expression();

					                      ((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).termStr =  ((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).t.termStr + ((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).MULOP->getText() + ((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).unaryExpr.unaryExprStr;
					                      ((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).type =  ((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).unaryExpr.type;
					                      bool errorDisplayType2 = false;

					                      if(((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).MULOP->getText() == "%")
					                      {
					                          ((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).type =  "int";
					                          if(((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).unaryExpr.type != "int" || ((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).t.type != "int")
					                          {                        
					                              // logError(_input->LT(-1)->getLine(), "Non-Integer operand on modulus operator");
					                              errorDisplayType2 = true;
					                              logAndErrorType2(_input->LT(-1)->getLine(), "term : term MULOP unary_expression", "Non-Integer operand on modulus operator" , _localctx.termStr);
					                              semanticErrorCount++;
					                          }

					                          if((((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).unaryExpr!=null?_input.getText(((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).unaryExpr.start,((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).unaryExpr.stop):null) == "0")
					                          {
					                              // logError(_input->LT(-1)->getLine(), "Modulus by Zero");
					                              errorDisplayType2 = true;
					                              logAndErrorType2(_input->LT(-1)->getLine(), "term : term MULOP unary_expression", "Modulus by Zero", _localctx.termStr);
					                              semanticErrorCount++;
					                          }
					                      }
					                      else if(((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).MULOP->getText() == "/")
					                      {
					                          if(((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).unaryExpr.type != "int" && ((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).unaryExpr.type != "float")
					                          {
					                              logError(_input->LT(-1)->getLine(), "Non-numeric operand on division operator");
					                              semanticErrorCount++;
					                          }

					                          if(((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).t.type != "int" && ((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).t.type != "float")
					                          {
					                              logError(_input->LT(-1)->getLine(), "Non-numeric operand on division operator");
					                              semanticErrorCount++;
					                          }

					                          if((((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).unaryExpr!=null?_input.getText(((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).unaryExpr.start,((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).unaryExpr.stop):null) == "0")
					                          {
					                              logError(_input->LT(-1)->getLine(), "Division by zero");
					                              semanticErrorCount++;
					                          }
					                      }

					                      if(((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).unaryExpr.funcNameIfFunction != "")
					                      {
					                          ((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).funcNameIfFunction =  ((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).unaryExpr.funcNameIfFunction;
					                          SymbolInfo* func = symbolTable->lookUp(((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).unaryExpr.funcNameIfFunction);
					                          if(func)
					                          {
					                              if(func->isFunction && !func->definedFunction)
					                              {
					                                  logError(_input->LT(-1)->getLine(), "Cannot use function " + ((TERM_TERM_MULOP_UNARY_EXPRESSIONContext)_localctx).unaryExpr.funcNameIfFunction + " in expression before definition");
					                                  semanticErrorCount++;
					                              }

					                              if(func->interpretedType == "void")
					                              {
					                                  // logError(_input->LT(-1)->getLine(), "Void function used in expression");
					                                  errorDisplayType2 = true;
					                                  logAndErrorType2(_input->LT(-1)->getLine(), "term : term MULOP unary_expression", "Void function used in expression", _localctx.termStr);
					                                  semanticErrorCount++;
					                              }

					                          }
					                      }
					                      
					                      if(errorDisplayType2 == false)
					                          logSSA(_input->LT(-1)->getLine(), "term : term MULOP unary_expression", _localctx.termStr);
					                  
					}
					} 
				}
				setState(490);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unary_expressionContext extends ParserRuleContext {
		public std::string unaryExprStr;
		public string type;
		public string funcNameIfFunction;
		public Unary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expression; }
	 
		public Unary_expressionContext() { }
		public void copyFrom(Unary_expressionContext ctx) {
			super.copyFrom(ctx);
			this.unaryExprStr = ctx.unaryExprStr;
			this.type = ctx.type;
			this.funcNameIfFunction = ctx.funcNameIfFunction;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UNARYEXPRESSION_NOT_UNARY_EXPRESSIONContext extends Unary_expressionContext {
		public Token NOT;
		public Unary_expressionContext unaryExpr;
		public TerminalNode NOT() { return getToken(C2105055Parser.NOT, 0); }
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public UNARYEXPRESSION_NOT_UNARY_EXPRESSIONContext(Unary_expressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UNARYEXPRESSION_FACTORContext extends Unary_expressionContext {
		public FactorContext fctr;
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public UNARYEXPRESSION_FACTORContext(Unary_expressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UNARYEXPRESSION_ADDOP_UNARY_EXPRESSIONContext extends Unary_expressionContext {
		public Token ADDOP;
		public Unary_expressionContext unaryExpr;
		public TerminalNode ADDOP() { return getToken(C2105055Parser.ADDOP, 0); }
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public UNARYEXPRESSION_ADDOP_UNARY_EXPRESSIONContext(Unary_expressionContext ctx) { copyFrom(ctx); }
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_unary_expression);
		try {
			setState(502);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADDOP:
				_localctx = new UNARYEXPRESSION_ADDOP_UNARY_EXPRESSIONContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(491);
				((UNARYEXPRESSION_ADDOP_UNARY_EXPRESSIONContext)_localctx).ADDOP = match(ADDOP);
				setState(492);
				((UNARYEXPRESSION_ADDOP_UNARY_EXPRESSIONContext)_localctx).unaryExpr = unary_expression();

				            ((UNARYEXPRESSION_ADDOP_UNARY_EXPRESSIONContext)_localctx).unaryExprStr =  ((UNARYEXPRESSION_ADDOP_UNARY_EXPRESSIONContext)_localctx).ADDOP->getText() + ((UNARYEXPRESSION_ADDOP_UNARY_EXPRESSIONContext)_localctx).unaryExpr.unaryExprStr;
				            ((UNARYEXPRESSION_ADDOP_UNARY_EXPRESSIONContext)_localctx).type =  ((UNARYEXPRESSION_ADDOP_UNARY_EXPRESSIONContext)_localctx).unaryExpr.type;

				            logSSA(_input->LT(-1)->getLine(), "unary_expression : ADDOP unary_expression", _localctx.unaryExprStr);
				        
				}
				break;
			case NOT:
				_localctx = new UNARYEXPRESSION_NOT_UNARY_EXPRESSIONContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(495);
				((UNARYEXPRESSION_NOT_UNARY_EXPRESSIONContext)_localctx).NOT = match(NOT);
				setState(496);
				((UNARYEXPRESSION_NOT_UNARY_EXPRESSIONContext)_localctx).unaryExpr = unary_expression();

				            ((UNARYEXPRESSION_NOT_UNARY_EXPRESSIONContext)_localctx).unaryExprStr =  ((UNARYEXPRESSION_NOT_UNARY_EXPRESSIONContext)_localctx).NOT->getText() + ((UNARYEXPRESSION_NOT_UNARY_EXPRESSIONContext)_localctx).unaryExpr.unaryExprStr;
				            if(((UNARYEXPRESSION_NOT_UNARY_EXPRESSIONContext)_localctx).unaryExpr.type != "int") // C doesn't technically have bool :3, don't change laterr
				            {
				                logError(_input->LT(-1)->getLine(), "Non-Boolean operand on NOT operator");
				                semanticErrorCount++;
				            }
				            ((UNARYEXPRESSION_NOT_UNARY_EXPRESSIONContext)_localctx).type =  "int"; // C doesn't technically have bool :3, don't change laterr
				            logSSA(_input->LT(-1)->getLine(), "unary_expression : NOT unary_expression", _localctx.unaryExprStr);
				        
				}
				break;
			case LPAREN:
			case ID:
			case CONST_INT:
			case CONST_FLOAT:
				_localctx = new UNARYEXPRESSION_FACTORContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(499);
				((UNARYEXPRESSION_FACTORContext)_localctx).fctr = factor();

				            ((UNARYEXPRESSION_FACTORContext)_localctx).unaryExprStr =  ((UNARYEXPRESSION_FACTORContext)_localctx).fctr.factorStr;
				            ((UNARYEXPRESSION_FACTORContext)_localctx).type =  ((UNARYEXPRESSION_FACTORContext)_localctx).fctr.type;
				            ((UNARYEXPRESSION_FACTORContext)_localctx).funcNameIfFunction =  ((UNARYEXPRESSION_FACTORContext)_localctx).fctr.funcNameIfFunction;
				            cout << "Line :" << _input->LT(-1)->getLine() << " type of factor " << _localctx.unaryExprStr << " " << ((UNARYEXPRESSION_FACTORContext)_localctx).fctr.type << endl;
				            logSSA(_input->LT(-1)->getLine(), "unary_expression : factor", _localctx.unaryExprStr);
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public std::string factorStr;
		public string type;
		public string funcNameIfFunction;
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	 
		public FactorContext() { }
		public void copyFrom(FactorContext ctx) {
			super.copyFrom(ctx);
			this.factorStr = ctx.factorStr;
			this.type = ctx.type;
			this.funcNameIfFunction = ctx.funcNameIfFunction;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FACTOR_EXPRESSIONContext extends FactorContext {
		public Token LPAREN;
		public ExpressionContext expr;
		public Token RPAREN;
		public TerminalNode LPAREN() { return getToken(C2105055Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(C2105055Parser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FACTOR_EXPRESSIONContext(FactorContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FACTOR_VARIABLEContext extends FactorContext {
		public VariableContext var;
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public FACTOR_VARIABLEContext(FactorContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FACTOR_CONST_INTContext extends FactorContext {
		public Token CONST_INT;
		public TerminalNode CONST_INT() { return getToken(C2105055Parser.CONST_INT, 0); }
		public FACTOR_CONST_INTContext(FactorContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FACTOR_VARIABLE_DECContext extends FactorContext {
		public VariableContext var;
		public Token DECOP;
		public TerminalNode DECOP() { return getToken(C2105055Parser.DECOP, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public FACTOR_VARIABLE_DECContext(FactorContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FACTOR_VARIABLE_INCContext extends FactorContext {
		public VariableContext var;
		public Token INCOP;
		public TerminalNode INCOP() { return getToken(C2105055Parser.INCOP, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public FACTOR_VARIABLE_INCContext(FactorContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FACTOR_FUNCTION_CALLContext extends FactorContext {
		public Token ID;
		public Token LPAREN;
		public Argument_listContext args;
		public Token RPAREN;
		public TerminalNode ID() { return getToken(C2105055Parser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(C2105055Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(C2105055Parser.RPAREN, 0); }
		public Argument_listContext argument_list() {
			return getRuleContext(Argument_listContext.class,0);
		}
		public FACTOR_FUNCTION_CALLContext(FactorContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FACTOR_CONST_FLOATContext extends FactorContext {
		public Token CONST_FLOAT;
		public TerminalNode CONST_FLOAT() { return getToken(C2105055Parser.CONST_FLOAT, 0); }
		public FACTOR_CONST_FLOATContext(FactorContext ctx) { copyFrom(ctx); }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_factor);
		try {
			setState(530);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				_localctx = new FACTOR_VARIABLEContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(504);
				((FACTOR_VARIABLEContext)_localctx).var = variable();

				            ((FACTOR_VARIABLEContext)_localctx).factorStr =  ((FACTOR_VARIABLEContext)_localctx).var.varExpr;
				            
				            SymbolInfo* varInfo = symbolTable->lookUp(((FACTOR_VARIABLEContext)_localctx).var.varName);
				            if(varInfo)
				            {
				                ((FACTOR_VARIABLEContext)_localctx).type =  varInfo->interpretedType;
				                if (varInfo->isArray) {
				                    // logError(_input->LT(-1)->getLine(), "Type mismatch, " + ((FACTOR_VARIABLEContext)_localctx).var.varExpr + " is an array");
				                    // semanticErrorCount++;
				                }
				                else if (varInfo->isFunction) {
				                    logError(_input->LT(-1)->getLine(), "Type mismatch, " + ((FACTOR_VARIABLEContext)_localctx).var.varExpr + " is a function");
				                    semanticErrorCount++;
				                }
				            }
				            else
				            {
				                logError(_input->LT(-1)->getLine(), "Undeclared variable " + ((FACTOR_VARIABLEContext)_localctx).var.varExpr);
				                semanticErrorCount++;
				                ((FACTOR_VARIABLEContext)_localctx).type =  "undeclared";
				            }

				            cout << "LINE :" << _input->LT(-1)->getLine() << " type of variable: " << ((FACTOR_VARIABLEContext)_localctx).var.type << endl;
				            logSSA(_input->LT(-1)->getLine(), "factor : variable", _localctx.factorStr);
				        
				}
				break;
			case 2:
				_localctx = new FACTOR_FUNCTION_CALLContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(507);
				((FACTOR_FUNCTION_CALLContext)_localctx).ID = match(ID);
				setState(508);
				((FACTOR_FUNCTION_CALLContext)_localctx).LPAREN = match(LPAREN);
				setState(509);
				((FACTOR_FUNCTION_CALLContext)_localctx).args = argument_list();
				setState(510);
				((FACTOR_FUNCTION_CALLContext)_localctx).RPAREN = match(RPAREN);

				            ((FACTOR_FUNCTION_CALLContext)_localctx).factorStr =  ((FACTOR_FUNCTION_CALLContext)_localctx).ID->getText() + ((FACTOR_FUNCTION_CALLContext)_localctx).LPAREN->getText() + ((FACTOR_FUNCTION_CALLContext)_localctx).args.argListStr + ((FACTOR_FUNCTION_CALLContext)_localctx).RPAREN->getText();
				            ((FACTOR_FUNCTION_CALLContext)_localctx).funcNameIfFunction =  ((FACTOR_FUNCTION_CALLContext)_localctx).ID->getText();
				            bool errorDisplayType2 = false;

				            SymbolInfo* func = symbolTable->lookUp(((FACTOR_FUNCTION_CALLContext)_localctx).ID->getText());
				            if(!func || !func->isFunction)
				            {
				                // logError(_input->LT(-1)->getLine(), "Undefined function " + ((FACTOR_FUNCTION_CALLContext)_localctx).ID->getText());
				                errorDisplayType2 = true;
				                logAndErrorType2(_input->LT(-1)->getLine(), "factor : ID LPAREN argument_list RPAREN", "Undefined function " + ((FACTOR_FUNCTION_CALLContext)_localctx).ID->getText(), _localctx.factorStr);
				                semanticErrorCount++;
				                ((FACTOR_FUNCTION_CALLContext)_localctx).type =  "undefined";
				            }
				            else
				            {
				                ((FACTOR_FUNCTION_CALLContext)_localctx).type =  func->interpretedType;

				                vector<string> paramTypes;
				                vector<string> argumentTypes = ((FACTOR_FUNCTION_CALLContext)_localctx).args.typeList.get_variables();

				                for (auto& param : func->parameters) {
				                    paramTypes.push_back(param_type(param));
				                }
				                

				                if(paramTypes.size() != argumentTypes.size())
				                {
				                    // logError(_input->LT(-1)->getLine(), "Total number of arguments mismatch with declaration in function " + ((FACTOR_FUNCTION_CALLContext)_localctx).ID->getText());
				                    errorDisplayType2 = true;
				                    logAndErrorType2(_input->LT(-1)->getLine(), "factor : ID LPAREN argument_list RPAREN", "Total number of arguments mismatch with declaration in function " + ((FACTOR_FUNCTION_CALLContext)_localctx).ID->getText(), _localctx.factorStr);
				                    semanticErrorCount++;
				                }
				                else
				                {
				                    for (size_t i = 0; i < paramTypes.size(); ++i) {
				                        if (paramTypes[i] != argumentTypes[i]
				                            // && !(paramTypes[i] == "int" && argumentTypes[i] == "float")
				                            && !(paramTypes[i] == "float" && argumentTypes[i] == "int")) {
				                            // cout << "Param type: " << paramTypes[i] << " Argument type: " << argumentTypes[i] << endl;
				                            // logError(_input->LT(-1)->getLine(), to_string(i+1) + "th argument mismatch in function " + ((FACTOR_FUNCTION_CALLContext)_localctx).ID->getText());
				                            errorDisplayType2 = true;
				                            logAndErrorType2(_input->LT(-1)->getLine(), "factor : ID LPAREN argument_list RPAREN", to_string(i+1) + "th argument mismatch in function " + ((FACTOR_FUNCTION_CALLContext)_localctx).ID->getText(), _localctx.factorStr);
				                            semanticErrorCount++;
				                            break;
				                        }
				                    }
				                }
				            }

				            if(errorDisplayType2 == false)
				                logSSA(_input->LT(-1)->getLine(), "factor : ID LPAREN argument_list RPAREN", _localctx.factorStr);
				        
				}
				break;
			case 3:
				_localctx = new FACTOR_EXPRESSIONContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(513);
				((FACTOR_EXPRESSIONContext)_localctx).LPAREN = match(LPAREN);
				setState(514);
				((FACTOR_EXPRESSIONContext)_localctx).expr = expression(0);
				setState(515);
				((FACTOR_EXPRESSIONContext)_localctx).RPAREN = match(RPAREN);

				            ((FACTOR_EXPRESSIONContext)_localctx).factorStr =  ((FACTOR_EXPRESSIONContext)_localctx).LPAREN->getText() + ((FACTOR_EXPRESSIONContext)_localctx).expr.exprStr + ((FACTOR_EXPRESSIONContext)_localctx).RPAREN->getText();
				            ((FACTOR_EXPRESSIONContext)_localctx).type =  ((FACTOR_EXPRESSIONContext)_localctx).expr.type; 
				            logSSA(_input->LT(-1)->getLine(), "factor : LPAREN expression RPAREN", _localctx.factorStr);
				        
				}
				break;
			case 4:
				_localctx = new FACTOR_CONST_INTContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(518);
				((FACTOR_CONST_INTContext)_localctx).CONST_INT = match(CONST_INT);

				            ((FACTOR_CONST_INTContext)_localctx).factorStr =  ((FACTOR_CONST_INTContext)_localctx).CONST_INT->getText();
				            ((FACTOR_CONST_INTContext)_localctx).type =  "int";
				            logSSA(_input->LT(-1)->getLine(), "factor : CONST_INT", _localctx.factorStr);
				        
				}
				break;
			case 5:
				_localctx = new FACTOR_CONST_FLOATContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(520);
				((FACTOR_CONST_FLOATContext)_localctx).CONST_FLOAT = match(CONST_FLOAT);

				            ((FACTOR_CONST_FLOATContext)_localctx).factorStr =  ((FACTOR_CONST_FLOATContext)_localctx).CONST_FLOAT->getText();
				            ((FACTOR_CONST_FLOATContext)_localctx).type =  "float";
				            logSSA(_input->LT(-1)->getLine(), "factor : CONST_FLOAT", _localctx.factorStr);
				        
				}
				break;
			case 6:
				_localctx = new FACTOR_VARIABLE_INCContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(522);
				((FACTOR_VARIABLE_INCContext)_localctx).var = variable();
				setState(523);
				((FACTOR_VARIABLE_INCContext)_localctx).INCOP = match(INCOP);

				            ((FACTOR_VARIABLE_INCContext)_localctx).factorStr =  ((FACTOR_VARIABLE_INCContext)_localctx).var.varExpr + ((FACTOR_VARIABLE_INCContext)_localctx).INCOP->getText();
				            SymbolInfo* varInfo = symbolTable->lookUp(((FACTOR_VARIABLE_INCContext)_localctx).var.varName);
				            if(varInfo)
				            {
				                if (varInfo->isFunction) {
				                    logError(_input->LT(-1)->getLine(), "Type mismatch, " + ((FACTOR_VARIABLE_INCContext)_localctx).var.varExpr + " is a function");
				                    semanticErrorCount++;
				                }

				                ((FACTOR_VARIABLE_INCContext)_localctx).type =  varInfo->interpretedType;

				            }
				            else
				            {
				                logError(_input->LT(-1)->getLine(), "Undeclared variable " + ((FACTOR_VARIABLE_INCContext)_localctx).var.varExpr);
				                semanticErrorCount++;
				                ((FACTOR_VARIABLE_INCContext)_localctx).type =  "undeclared";
				            }

				            logSSA(_input->LT(-1)->getLine(), "factor : variable INCOP", _localctx.factorStr);
				        
				}
				break;
			case 7:
				_localctx = new FACTOR_VARIABLE_DECContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(526);
				((FACTOR_VARIABLE_DECContext)_localctx).var = variable();
				setState(527);
				((FACTOR_VARIABLE_DECContext)_localctx).DECOP = match(DECOP);

				            ((FACTOR_VARIABLE_DECContext)_localctx).factorStr =  ((FACTOR_VARIABLE_DECContext)_localctx).var.varExpr + ((FACTOR_VARIABLE_DECContext)_localctx).DECOP->getText();
				            SymbolInfo* varInfo = symbolTable->lookUp(((FACTOR_VARIABLE_DECContext)_localctx).var.varName);
				            if(varInfo)
				            {
				                if (varInfo->isFunction) {
				                    logError(_input->LT(-1)->getLine(), "Type mismatch, " + ((FACTOR_VARIABLE_DECContext)_localctx).var.varExpr + " is a function");
				                    semanticErrorCount++;
				                }

				                ((FACTOR_VARIABLE_DECContext)_localctx).type =  varInfo->interpretedType;

				            }
				            else
				            {
				                logError(_input->LT(-1)->getLine(), "Undeclared variable " + ((FACTOR_VARIABLE_DECContext)_localctx).var.varExpr);
				                semanticErrorCount++;
				                ((FACTOR_VARIABLE_DECContext)_localctx).type =  "undeclared";
				            }

				            logSSA(_input->LT(-1)->getLine(), "factor : variable DECOP", _localctx.factorStr);
				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Argument_listContext extends ParserRuleContext {
		public string argListStr;
		public str_list argList;
		public str_list typeList;
		public ArgumentsContext arguments;
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public Argument_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument_list; }
	}

	public final Argument_listContext argument_list() throws RecognitionException {
		Argument_listContext _localctx = new Argument_listContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_argument_list);
		try {
			setState(536);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case ADDOP:
			case NOT:
			case ASSIGNOP:
			case ID:
			case CONST_INT:
			case CONST_FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(532);
				((Argument_listContext)_localctx).arguments = arguments(0);

				                ((Argument_listContext)_localctx).argListStr =  ((Argument_listContext)_localctx).arguments.argStr;
				                _localctx.argList.set_variables(((Argument_listContext)_localctx).arguments.argList.get_variables());
				                _localctx.typeList.set_variables(((Argument_listContext)_localctx).arguments.typeList.get_variables());
				                for(int i = 0; i < _localctx.typeList.get_variables().size(); i++)
				                {
				                    cout << _localctx.typeList.get_variables()[i] << " ";
				                }
				                cout << endl;

				                logSSA(_input->LT(-1)->getLine(), "argument_list : arguments", _localctx.argListStr);
				            
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public string argStr;
		public str_list argList;
		public str_list typeList;
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	 
		public ArgumentsContext() { }
		public void copyFrom(ArgumentsContext ctx) {
			super.copyFrom(ctx);
			this.argStr = ctx.argStr;
			this.argList = ctx.argList;
			this.typeList = ctx.typeList;
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ARGUMENTS_LOGIC_EXPRESSIONContext extends ArgumentsContext {
		public Logic_expressionContext logicExpr;
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public ARGUMENTS_LOGIC_EXPRESSIONContext(ArgumentsContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ARGUMENTS_ARGUMENTS_COMMA_LOGIC_EXPRESSIONContext extends ArgumentsContext {
		public ArgumentsContext args;
		public Logic_expressionContext logicExpr;
		public TerminalNode COMMA() { return getToken(C2105055Parser.COMMA, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public ARGUMENTS_ARGUMENTS_COMMA_LOGIC_EXPRESSIONContext(ArgumentsContext ctx) { copyFrom(ctx); }
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		return arguments(0);
	}

	private ArgumentsContext arguments(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, _parentState);
		ArgumentsContext _prevctx = _localctx;
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_arguments, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ARGUMENTS_LOGIC_EXPRESSIONContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(539);
			((ARGUMENTS_LOGIC_EXPRESSIONContext)_localctx).logicExpr = logic_expression();

			                ((ARGUMENTS_LOGIC_EXPRESSIONContext)_localctx).argStr =  ((ARGUMENTS_LOGIC_EXPRESSIONContext)_localctx).logicExpr.logicExprStr;

			                _localctx.argList.set_variables({((ARGUMENTS_LOGIC_EXPRESSIONContext)_localctx).logicExpr.logicExprStr});
			                _localctx.typeList.set_variables({});
			                _localctx.typeList.add(((ARGUMENTS_LOGIC_EXPRESSIONContext)_localctx).logicExpr.type);

			                logSSA(_input->LT(-1)->getLine(), "arguments : logic_expression", _localctx.argStr);
			            
			}
			_ctx.stop = _input.LT(-1);
			setState(549);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ARGUMENTS_ARGUMENTS_COMMA_LOGIC_EXPRESSIONContext(new ArgumentsContext(_parentctx, _parentState));
					((ARGUMENTS_ARGUMENTS_COMMA_LOGIC_EXPRESSIONContext)_localctx).args = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_arguments);
					setState(542);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(543);
					match(COMMA);
					setState(544);
					((ARGUMENTS_ARGUMENTS_COMMA_LOGIC_EXPRESSIONContext)_localctx).logicExpr = logic_expression();

					                          ((ARGUMENTS_ARGUMENTS_COMMA_LOGIC_EXPRESSIONContext)_localctx).argStr =  ((ARGUMENTS_ARGUMENTS_COMMA_LOGIC_EXPRESSIONContext)_localctx).args.argStr + "," + ((ARGUMENTS_ARGUMENTS_COMMA_LOGIC_EXPRESSIONContext)_localctx).logicExpr.logicExprStr;
					                          cout << _localctx.argStr << endl;

					                          _localctx.argList.set_variables(((ARGUMENTS_ARGUMENTS_COMMA_LOGIC_EXPRESSIONContext)_localctx).args.argList.get_variables());
					                          _localctx.argList.add(((ARGUMENTS_ARGUMENTS_COMMA_LOGIC_EXPRESSIONContext)_localctx).logicExpr.logicExprStr);

					                          _localctx.typeList.set_variables(((ARGUMENTS_ARGUMENTS_COMMA_LOGIC_EXPRESSIONContext)_localctx).args.typeList.get_variables());
					                          _localctx.typeList.add(((ARGUMENTS_ARGUMENTS_COMMA_LOGIC_EXPRESSIONContext)_localctx).logicExpr.type);

					                          logSSA(_input->LT(-1)->getLine(), "arguments : arguments COMMA logic_expression", _localctx.argStr);
					                      
					}
					} 
				}
				setState(551);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return program_sempred((ProgramContext)_localctx, predIndex);
		case 5:
			return parameter_list_sempred((Parameter_listContext)_localctx, predIndex);
		case 8:
			return var_declaration_list_sempred((Var_declaration_listContext)_localctx, predIndex);
		case 12:
			return declaration_list_sempred((Declaration_listContext)_localctx, predIndex);
		case 13:
			return statements_sempred((StatementsContext)_localctx, predIndex);
		case 23:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 26:
			return simple_expression_sempred((Simple_expressionContext)_localctx, predIndex);
		case 27:
			return term_sempred((TermContext)_localctx, predIndex);
		case 31:
			return arguments_sempred((ArgumentsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean program_sempred(ProgramContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean parameter_list_sempred(Parameter_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean var_declaration_list_sempred(Var_declaration_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean declaration_list_sempred(Declaration_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 5);
		case 6:
			return precpred(_ctx, 4);
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean statements_sempred(StatementsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean simple_expression_sempred(Simple_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean arguments_sempred(ArgumentsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001*\u0229\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001M\b\u0001\n\u0001\f\u0001P\t\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002a\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003r\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004\u0088\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0092\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0005\u0005\u00a2\b\u0005\n\u0005\f\u0005\u00a5"+
		"\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00b1"+
		"\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00c9"+
		"\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0005\b\u00d3\b\b\n\b\f\b\u00d6\t\b\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00e8\b\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u00f2\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u0103"+
		"\b\f\n\f\f\f\u0106\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0005\r\u0110\b\r\n\r\f\r\u0113\t\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u016b\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0003\u0011\u0171\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u017a\b\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u018c\b\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003"+
		"\u0015\u0194\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u019e\b\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0003\u0017\u01ae\b\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0005\u0017\u01b3\b\u0017\n\u0017\f\u0017\u01b6\t\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0003\u0018\u01c0\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019"+
		"\u01ca\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u01d5\b\u001a"+
		"\n\u001a\f\u001a\u01d8\t\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u01e0\b\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u01e7\b\u001b\n"+
		"\u001b\f\u001b\u01ea\t\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0003\u001c\u01f7\b\u001c\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003"+
		"\u001d\u0213\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003"+
		"\u001e\u0219\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0005\u001f\u0224"+
		"\b\u001f\n\u001f\f\u001f\u0227\t\u001f\u0001\u001f\u0000\t\u0002\n\u0010"+
		"\u0018\u001a.46> \u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>\u0000\u0000\u0242\u0000"+
		"@\u0001\u0000\u0000\u0000\u0002D\u0001\u0000\u0000\u0000\u0004`\u0001"+
		"\u0000\u0000\u0000\u0006q\u0001\u0000\u0000\u0000\b\u0087\u0001\u0000"+
		"\u0000\u0000\n\u0091\u0001\u0000\u0000\u0000\f\u00b0\u0001\u0000\u0000"+
		"\u0000\u000e\u00c8\u0001\u0000\u0000\u0000\u0010\u00ca\u0001\u0000\u0000"+
		"\u0000\u0012\u00d7\u0001\u0000\u0000\u0000\u0014\u00df\u0001\u0000\u0000"+
		"\u0000\u0016\u00e7\u0001\u0000\u0000\u0000\u0018\u00f1\u0001\u0000\u0000"+
		"\u0000\u001a\u0107\u0001\u0000\u0000\u0000\u001c\u0114\u0001\u0000\u0000"+
		"\u0000\u001e\u011e\u0001\u0000\u0000\u0000 \u016a\u0001\u0000\u0000\u0000"+
		"\"\u0170\u0001\u0000\u0000\u0000$\u0179\u0001\u0000\u0000\u0000&\u017b"+
		"\u0001\u0000\u0000\u0000(\u018b\u0001\u0000\u0000\u0000*\u0193\u0001\u0000"+
		"\u0000\u0000,\u019d\u0001\u0000\u0000\u0000.\u01ad\u0001\u0000\u0000\u0000"+
		"0\u01bf\u0001\u0000\u0000\u00002\u01c9\u0001\u0000\u0000\u00004\u01cb"+
		"\u0001\u0000\u0000\u00006\u01df\u0001\u0000\u0000\u00008\u01f6\u0001\u0000"+
		"\u0000\u0000:\u0212\u0001\u0000\u0000\u0000<\u0218\u0001\u0000\u0000\u0000"+
		">\u021a\u0001\u0000\u0000\u0000@A\u0006\u0000\uffff\uffff\u0000AB\u0003"+
		"\u0002\u0001\u0000BC\u0006\u0000\uffff\uffff\u0000C\u0001\u0001\u0000"+
		"\u0000\u0000DE\u0006\u0001\uffff\uffff\u0000EF\u0003\u0004\u0002\u0000"+
		"FG\u0006\u0001\uffff\uffff\u0000GN\u0001\u0000\u0000\u0000HI\n\u0002\u0000"+
		"\u0000IJ\u0003\u0004\u0002\u0000JK\u0006\u0001\uffff\uffff\u0000KM\u0001"+
		"\u0000\u0000\u0000LH\u0001\u0000\u0000\u0000MP\u0001\u0000\u0000\u0000"+
		"NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000O\u0003\u0001\u0000"+
		"\u0000\u0000PN\u0001\u0000\u0000\u0000QR\u0003\u000e\u0007\u0000RS\u0006"+
		"\u0002\uffff\uffff\u0000Sa\u0001\u0000\u0000\u0000TU\u0003\u0006\u0003"+
		"\u0000UV\u0006\u0002\uffff\uffff\u0000Va\u0001\u0000\u0000\u0000WX\u0003"+
		"\b\u0004\u0000XY\u0006\u0002\uffff\uffff\u0000Ya\u0001\u0000\u0000\u0000"+
		"Z[\u0003\u0012\t\u0000[\\\u0006\u0002\uffff\uffff\u0000\\a\u0001\u0000"+
		"\u0000\u0000]^\u0003 \u0010\u0000^_\u0006\u0002\uffff\uffff\u0000_a\u0001"+
		"\u0000\u0000\u0000`Q\u0001\u0000\u0000\u0000`T\u0001\u0000\u0000\u0000"+
		"`W\u0001\u0000\u0000\u0000`Z\u0001\u0000\u0000\u0000`]\u0001\u0000\u0000"+
		"\u0000a\u0005\u0001\u0000\u0000\u0000bc\u0003\u0016\u000b\u0000cd\u0005"+
		"\'\u0000\u0000de\u0005\u0015\u0000\u0000ef\u0003\n\u0005\u0000fg\u0005"+
		"\u0016\u0000\u0000gh\u0005\u001b\u0000\u0000hi\u0006\u0003\uffff\uffff"+
		"\u0000ir\u0001\u0000\u0000\u0000jk\u0003\u0016\u000b\u0000kl\u0005\'\u0000"+
		"\u0000lm\u0005\u0015\u0000\u0000mn\u0005\u0016\u0000\u0000no\u0005\u001b"+
		"\u0000\u0000op\u0006\u0003\uffff\uffff\u0000pr\u0001\u0000\u0000\u0000"+
		"qb\u0001\u0000\u0000\u0000qj\u0001\u0000\u0000\u0000r\u0007\u0001\u0000"+
		"\u0000\u0000st\u0006\u0004\uffff\uffff\u0000tu\u0003\u0016\u000b\u0000"+
		"uv\u0005\'\u0000\u0000vw\u0006\u0004\uffff\uffff\u0000wx\u0005\u0015\u0000"+
		"\u0000xy\u0003\n\u0005\u0000yz\u0005\u0016\u0000\u0000z{\u0006\u0004\uffff"+
		"\uffff\u0000{|\u0003\f\u0006\u0000|}\u0006\u0004\uffff\uffff\u0000}\u0088"+
		"\u0001\u0000\u0000\u0000~\u007f\u0003\u0016\u000b\u0000\u007f\u0080\u0005"+
		"\'\u0000\u0000\u0080\u0081\u0005\u0015\u0000\u0000\u0081\u0082\u0006\u0004"+
		"\uffff\uffff\u0000\u0082\u0083\u0005\u0016\u0000\u0000\u0083\u0084\u0006"+
		"\u0004\uffff\uffff\u0000\u0084\u0085\u0003\f\u0006\u0000\u0085\u0086\u0006"+
		"\u0004\uffff\uffff\u0000\u0086\u0088\u0001\u0000\u0000\u0000\u0087s\u0001"+
		"\u0000\u0000\u0000\u0087~\u0001\u0000\u0000\u0000\u0088\t\u0001\u0000"+
		"\u0000\u0000\u0089\u008a\u0006\u0005\uffff\uffff\u0000\u008a\u008b\u0003"+
		"\u0016\u000b\u0000\u008b\u008c\u0005\'\u0000\u0000\u008c\u008d\u0006\u0005"+
		"\uffff\uffff\u0000\u008d\u0092\u0001\u0000\u0000\u0000\u008e\u008f\u0003"+
		"\u0016\u000b\u0000\u008f\u0090\u0006\u0005\uffff\uffff\u0000\u0090\u0092"+
		"\u0001\u0000\u0000\u0000\u0091\u0089\u0001\u0000\u0000\u0000\u0091\u008e"+
		"\u0001\u0000\u0000\u0000\u0092\u00a3\u0001\u0000\u0000\u0000\u0093\u0094"+
		"\n\u0005\u0000\u0000\u0094\u0095\u0005\u001c\u0000\u0000\u0095\u0096\u0003"+
		"\u0016\u000b\u0000\u0096\u0097\u0005\'\u0000\u0000\u0097\u0098\u0006\u0005"+
		"\uffff\uffff\u0000\u0098\u00a2\u0001\u0000\u0000\u0000\u0099\u009a\n\u0004"+
		"\u0000\u0000\u009a\u009b\u0005\u001c\u0000\u0000\u009b\u009c\u0003\u0016"+
		"\u000b\u0000\u009c\u009d\u0006\u0005\uffff\uffff\u0000\u009d\u00a2\u0001"+
		"\u0000\u0000\u0000\u009e\u009f\n\u0001\u0000\u0000\u009f\u00a0\u0005\u001e"+
		"\u0000\u0000\u00a0\u00a2\u0006\u0005\uffff\uffff\u0000\u00a1\u0093\u0001"+
		"\u0000\u0000\u0000\u00a1\u0099\u0001\u0000\u0000\u0000\u00a1\u009e\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u000b\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005"+
		"\u0017\u0000\u0000\u00a7\u00a8\u0006\u0006\uffff\uffff\u0000\u00a8\u00a9"+
		"\u0003\u001a\r\u0000\u00a9\u00aa\u0005\u0018\u0000\u0000\u00aa\u00ab\u0006"+
		"\u0006\uffff\uffff\u0000\u00ab\u00b1\u0001\u0000\u0000\u0000\u00ac\u00ad"+
		"\u0005\u0017\u0000\u0000\u00ad\u00ae\u0006\u0006\uffff\uffff\u0000\u00ae"+
		"\u00af\u0005\u0018\u0000\u0000\u00af\u00b1\u0006\u0006\uffff\uffff\u0000"+
		"\u00b0\u00a6\u0001\u0000\u0000\u0000\u00b0\u00ac\u0001\u0000\u0000\u0000"+
		"\u00b1\r\u0001\u0000\u0000\u0000\u00b2\u00b3\u0003\u0016\u000b\u0000\u00b3"+
		"\u00b4\u0003\u0018\f\u0000\u00b4\u00b5\u0005\u001b\u0000\u0000\u00b5\u00b6"+
		"\u0006\u0007\uffff\uffff\u0000\u00b6\u00c9\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b8\u0003\u0016\u000b\u0000\u00b8\u00b9\u0005\u001b\u0000\u0000\u00b9"+
		"\u00ba\u0006\u0007\uffff\uffff\u0000\u00ba\u00c9\u0001\u0000\u0000\u0000"+
		"\u00bb\u00bc\u0005\u0014\u0000\u0000\u00bc\u00bd\u0005\'\u0000\u0000\u00bd"+
		"\u00be\u0003\u0018\f\u0000\u00be\u00bf\u0005\u001b\u0000\u0000\u00bf\u00c0"+
		"\u0006\u0007\uffff\uffff\u0000\u00c0\u00c9\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c2\u0003\u0016\u000b\u0000\u00c2\u00c3\u0005\'\u0000\u0000\u00c3\u00c4"+
		"\u0005&\u0000\u0000\u00c4\u00c5\u00030\u0018\u0000\u00c5\u00c6\u0005\u001b"+
		"\u0000\u0000\u00c6\u00c7\u0006\u0007\uffff\uffff\u0000\u00c7\u00c9\u0001"+
		"\u0000\u0000\u0000\u00c8\u00b2\u0001\u0000\u0000\u0000\u00c8\u00b7\u0001"+
		"\u0000\u0000\u0000\u00c8\u00bb\u0001\u0000\u0000\u0000\u00c8\u00c1\u0001"+
		"\u0000\u0000\u0000\u00c9\u000f\u0001\u0000\u0000\u0000\u00ca\u00cb\u0006"+
		"\b\uffff\uffff\u0000\u00cb\u00cc\u0003\u000e\u0007\u0000\u00cc\u00cd\u0006"+
		"\b\uffff\uffff\u0000\u00cd\u00d4\u0001\u0000\u0000\u0000\u00ce\u00cf\n"+
		"\u0001\u0000\u0000\u00cf\u00d0\u0003\u000e\u0007\u0000\u00d0\u00d1\u0006"+
		"\b\uffff\uffff\u0000\u00d1\u00d3\u0001\u0000\u0000\u0000\u00d2\u00ce\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d6\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u0011\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d7\u00d8\u0005"+
		"\u0014\u0000\u0000\u00d8\u00d9\u0005\'\u0000\u0000\u00d9\u00da\u0005\u0017"+
		"\u0000\u0000\u00da\u00db\u0003\u0010\b\u0000\u00db\u00dc\u0005\u0018\u0000"+
		"\u0000\u00dc\u00dd\u0005\u001b\u0000\u0000\u00dd\u00de\u0006\t\uffff\uffff"+
		"\u0000\u00de\u0013\u0001\u0000\u0000\u0000\u00df\u00e0\u0006\n\uffff\uffff"+
		"\u0000\u00e0\u0015\u0001\u0000\u0000\u0000\u00e1\u00e2\u0005\u0011\u0000"+
		"\u0000\u00e2\u00e8\u0006\u000b\uffff\uffff\u0000\u00e3\u00e4\u0005\u0012"+
		"\u0000\u0000\u00e4\u00e8\u0006\u000b\uffff\uffff\u0000\u00e5\u00e6\u0005"+
		"\u0013\u0000\u0000\u00e6\u00e8\u0006\u000b\uffff\uffff\u0000\u00e7\u00e1"+
		"\u0001\u0000\u0000\u0000\u00e7\u00e3\u0001\u0000\u0000\u0000\u00e7\u00e5"+
		"\u0001\u0000\u0000\u0000\u00e8\u0017\u0001\u0000\u0000\u0000\u00e9\u00ea"+
		"\u0006\f\uffff\uffff\u0000\u00ea\u00eb\u0005\'\u0000\u0000\u00eb\u00f2"+
		"\u0006\f\uffff\uffff\u0000\u00ec\u00ed\u0005\'\u0000\u0000\u00ed\u00ee"+
		"\u0005\u0019\u0000\u0000\u00ee\u00ef\u0005(\u0000\u0000\u00ef\u00f0\u0005"+
		"\u001a\u0000\u0000\u00f0\u00f2\u0006\f\uffff\uffff\u0000\u00f1\u00e9\u0001"+
		"\u0000\u0000\u0000\u00f1\u00ec\u0001\u0000\u0000\u0000\u00f2\u0104\u0001"+
		"\u0000\u0000\u0000\u00f3\u00f4\n\u0005\u0000\u0000\u00f4\u00f5\u0005\u001c"+
		"\u0000\u0000\u00f5\u00f6\u0005\'\u0000\u0000\u00f6\u0103\u0006\f\uffff"+
		"\uffff\u0000\u00f7\u00f8\n\u0004\u0000\u0000\u00f8\u00f9\u0005\u001c\u0000"+
		"\u0000\u00f9\u00fa\u0005\'\u0000\u0000\u00fa\u00fb\u0005\u0019\u0000\u0000"+
		"\u00fb\u00fc\u0005(\u0000\u0000\u00fc\u00fd\u0005\u001a\u0000\u0000\u00fd"+
		"\u0103\u0006\f\uffff\uffff\u0000\u00fe\u00ff\n\u0001\u0000\u0000\u00ff"+
		"\u0100\u0005\u001e\u0000\u0000\u0100\u0101\u0005\'\u0000\u0000\u0101\u0103"+
		"\u0006\f\uffff\uffff\u0000\u0102\u00f3\u0001\u0000\u0000\u0000\u0102\u00f7"+
		"\u0001\u0000\u0000\u0000\u0102\u00fe\u0001\u0000\u0000\u0000\u0103\u0106"+
		"\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0104\u0105"+
		"\u0001\u0000\u0000\u0000\u0105\u0019\u0001\u0000\u0000\u0000\u0106\u0104"+
		"\u0001\u0000\u0000\u0000\u0107\u0108\u0006\r\uffff\uffff\u0000\u0108\u0109"+
		"\u0003 \u0010\u0000\u0109\u010a\u0006\r\uffff\uffff\u0000\u010a\u0111"+
		"\u0001\u0000\u0000\u0000\u010b\u010c\n\u0001\u0000\u0000\u010c\u010d\u0003"+
		" \u0010\u0000\u010d\u010e\u0006\r\uffff\uffff\u0000\u010e\u0110\u0001"+
		"\u0000\u0000\u0000\u010f\u010b\u0001\u0000\u0000\u0000\u0110\u0113\u0001"+
		"\u0000\u0000\u0000\u0111\u010f\u0001\u0000\u0000\u0000\u0111\u0112\u0001"+
		"\u0000\u0000\u0000\u0112\u001b\u0001\u0000\u0000\u0000\u0113\u0111\u0001"+
		"\u0000\u0000\u0000\u0114\u0115\u0005\u0007\u0000\u0000\u0115\u0116\u0005"+
		"\u0015\u0000\u0000\u0116\u0117\u0003.\u0017\u0000\u0117\u0118\u0005\u0016"+
		"\u0000\u0000\u0118\u0119\u0005\u0017\u0000\u0000\u0119\u011a\u0003$\u0012"+
		"\u0000\u011a\u011b\u0003(\u0014\u0000\u011b\u011c\u0005\u0018\u0000\u0000"+
		"\u011c\u011d\u0006\u000e\uffff\uffff\u0000\u011d\u001d\u0001\u0000\u0000"+
		"\u0000\u011e\u011f\u0005\u000e\u0000\u0000\u011f\u0120\u0006\u000f\uffff"+
		"\uffff\u0000\u0120\u0121\u0003\f\u0006\u0000\u0121\u0122\u0005\r\u0000"+
		"\u0000\u0122\u0123\u0005\u0015\u0000\u0000\u0123\u0124\u0003.\u0017\u0000"+
		"\u0124\u0125\u0005\u0016\u0000\u0000\u0125\u0126\u0005\u001b\u0000\u0000"+
		"\u0126\u0127\u0006\u000f\uffff\uffff\u0000\u0127\u001f\u0001\u0000\u0000"+
		"\u0000\u0128\u0129\u0003\u000e\u0007\u0000\u0129\u012a\u0006\u0010\uffff"+
		"\uffff\u0000\u012a\u016b\u0001\u0000\u0000\u0000\u012b\u012c\u0003*\u0015"+
		"\u0000\u012c\u012d\u0006\u0010\uffff\uffff\u0000\u012d\u016b\u0001\u0000"+
		"\u0000\u0000\u012e\u012f\u0003\f\u0006\u0000\u012f\u0130\u0006\u0010\uffff"+
		"\uffff\u0000\u0130\u016b\u0001\u0000\u0000\u0000\u0131\u0132\u0005\f\u0000"+
		"\u0000\u0132\u0133\u0005\u0015\u0000\u0000\u0133\u0134\u0003*\u0015\u0000"+
		"\u0134\u0135\u0003*\u0015\u0000\u0135\u0136\u0003.\u0017\u0000\u0136\u0137"+
		"\u0005\u0016\u0000\u0000\u0137\u0138\u0006\u0010\uffff\uffff\u0000\u0138"+
		"\u0139\u0003 \u0010\u0000\u0139\u013a\u0006\u0010\uffff\uffff\u0000\u013a"+
		"\u016b\u0001\u0000\u0000\u0000\u013b\u013c\u0005\u0005\u0000\u0000\u013c"+
		"\u013d\u0005\u0015\u0000\u0000\u013d\u013e\u0003.\u0017\u0000\u013e\u013f"+
		"\u0005\u0016\u0000\u0000\u013f\u0140\u0003 \u0010\u0000\u0140\u0141\u0006"+
		"\u0010\uffff\uffff\u0000\u0141\u016b\u0001\u0000\u0000\u0000\u0142\u0143"+
		"\u0005\u0005\u0000\u0000\u0143\u0144\u0005\u0015\u0000\u0000\u0144\u0145"+
		"\u0003.\u0017\u0000\u0145\u0146\u0005\u0016\u0000\u0000\u0146\u0147\u0003"+
		" \u0010\u0000\u0147\u0148\u0005\u0006\u0000\u0000\u0148\u0149\u0003 \u0010"+
		"\u0000\u0149\u014a\u0006\u0010\uffff\uffff\u0000\u014a\u016b\u0001\u0000"+
		"\u0000\u0000\u014b\u014c\u0005\r\u0000\u0000\u014c\u014d\u0006\u0010\uffff"+
		"\uffff\u0000\u014d\u014e\u0005\u0015\u0000\u0000\u014e\u014f\u0003.\u0017"+
		"\u0000\u014f\u0150\u0005\u0016\u0000\u0000\u0150\u0151\u0003 \u0010\u0000"+
		"\u0151\u0152\u0006\u0010\uffff\uffff\u0000\u0152\u016b\u0001\u0000\u0000"+
		"\u0000\u0153\u0154\u0005\u000f\u0000\u0000\u0154\u0155\u0005\u0015\u0000"+
		"\u0000\u0155\u0156\u0005\'\u0000\u0000\u0156\u0157\u0005\u0016\u0000\u0000"+
		"\u0157\u0158\u0005\u001b\u0000\u0000\u0158\u016b\u0006\u0010\uffff\uffff"+
		"\u0000\u0159\u015a\u0005\u0010\u0000\u0000\u015a\u015b\u0003.\u0017\u0000"+
		"\u015b\u015c\u0005\u001b\u0000\u0000\u015c\u015d\u0006\u0010\uffff\uffff"+
		"\u0000\u015d\u016b\u0001\u0000\u0000\u0000\u015e\u015f\u0003\u001c\u000e"+
		"\u0000\u015f\u0160\u0006\u0010\uffff\uffff\u0000\u0160\u016b\u0001\u0000"+
		"\u0000\u0000\u0161\u0162\u0005\n\u0000\u0000\u0162\u0163\u0005\u001b\u0000"+
		"\u0000\u0163\u016b\u0006\u0010\uffff\uffff\u0000\u0164\u0165\u0005\u000b"+
		"\u0000\u0000\u0165\u0166\u0005\u001b\u0000\u0000\u0166\u016b\u0006\u0010"+
		"\uffff\uffff\u0000\u0167\u0168\u0003\u001e\u000f\u0000\u0168\u0169\u0006"+
		"\u0010\uffff\uffff\u0000\u0169\u016b\u0001\u0000\u0000\u0000\u016a\u0128"+
		"\u0001\u0000\u0000\u0000\u016a\u012b\u0001\u0000\u0000\u0000\u016a\u012e"+
		"\u0001\u0000\u0000\u0000\u016a\u0131\u0001\u0000\u0000\u0000\u016a\u013b"+
		"\u0001\u0000\u0000\u0000\u016a\u0142\u0001\u0000\u0000\u0000\u016a\u014b"+
		"\u0001\u0000\u0000\u0000\u016a\u0153\u0001\u0000\u0000\u0000\u016a\u0159"+
		"\u0001\u0000\u0000\u0000\u016a\u015e\u0001\u0000\u0000\u0000\u016a\u0161"+
		"\u0001\u0000\u0000\u0000\u016a\u0164\u0001\u0000\u0000\u0000\u016a\u0167"+
		"\u0001\u0000\u0000\u0000\u016b!\u0001\u0000\u0000\u0000\u016c\u016d\u0005"+
		"(\u0000\u0000\u016d\u0171\u0006\u0011\uffff\uffff\u0000\u016e\u016f\u0005"+
		")\u0000\u0000\u016f\u0171\u0006\u0011\uffff\uffff\u0000\u0170\u016c\u0001"+
		"\u0000\u0000\u0000\u0170\u016e\u0001\u0000\u0000\u0000\u0171#\u0001\u0000"+
		"\u0000\u0000\u0172\u0173\u0003&\u0013\u0000\u0173\u0174\u0006\u0012\uffff"+
		"\uffff\u0000\u0174\u017a\u0001\u0000\u0000\u0000\u0175\u0176\u0003&\u0013"+
		"\u0000\u0176\u0177\u0003$\u0012\u0000\u0177\u0178\u0006\u0012\uffff\uffff"+
		"\u0000\u0178\u017a\u0001\u0000\u0000\u0000\u0179\u0172\u0001\u0000\u0000"+
		"\u0000\u0179\u0175\u0001\u0000\u0000\u0000\u017a%\u0001\u0000\u0000\u0000"+
		"\u017b\u017c\u0005\b\u0000\u0000\u017c\u017d\u0003\"\u0011\u0000\u017d"+
		"\u017e\u0005\u001d\u0000\u0000\u017e\u017f\u0003\u001a\r\u0000\u017f\u0180"+
		"\u0005\n\u0000\u0000\u0180\u0181\u0005\u001b\u0000\u0000\u0181\u0182\u0006"+
		"\u0013\uffff\uffff\u0000\u0182\'\u0001\u0000\u0000\u0000\u0183\u0184\u0005"+
		"\t\u0000\u0000\u0184\u0185\u0005\u001d\u0000\u0000\u0185\u0186\u0003\u001a"+
		"\r\u0000\u0186\u0187\u0005\n\u0000\u0000\u0187\u0188\u0005\u001b\u0000"+
		"\u0000\u0188\u0189\u0006\u0014\uffff\uffff\u0000\u0189\u018c\u0001\u0000"+
		"\u0000\u0000\u018a\u018c\u0001\u0000\u0000\u0000\u018b\u0183\u0001\u0000"+
		"\u0000\u0000\u018b\u018a\u0001\u0000\u0000\u0000\u018c)\u0001\u0000\u0000"+
		"\u0000\u018d\u018e\u0005\u001b\u0000\u0000\u018e\u0194\u0006\u0015\uffff"+
		"\uffff\u0000\u018f\u0190\u0003.\u0017\u0000\u0190\u0191\u0005\u001b\u0000"+
		"\u0000\u0191\u0192\u0006\u0015\uffff\uffff\u0000\u0192\u0194\u0001\u0000"+
		"\u0000\u0000\u0193\u018d\u0001\u0000\u0000\u0000\u0193\u018f\u0001\u0000"+
		"\u0000\u0000\u0194+\u0001\u0000\u0000\u0000\u0195\u0196\u0005\'\u0000"+
		"\u0000\u0196\u019e\u0006\u0016\uffff\uffff\u0000\u0197\u0198\u0005\'\u0000"+
		"\u0000\u0198\u0199\u0005\u0019\u0000\u0000\u0199\u019a\u0003.\u0017\u0000"+
		"\u019a\u019b\u0005\u001a\u0000\u0000\u019b\u019c\u0006\u0016\uffff\uffff"+
		"\u0000\u019c\u019e\u0001\u0000\u0000\u0000\u019d\u0195\u0001\u0000\u0000"+
		"\u0000\u019d\u0197\u0001\u0000\u0000\u0000\u019e-\u0001\u0000\u0000\u0000"+
		"\u019f\u01a0\u0006\u0017\uffff\uffff\u0000\u01a0\u01a1\u00030\u0018\u0000"+
		"\u01a1\u01a2\u0006\u0017\uffff\uffff\u0000\u01a2\u01ae\u0001\u0000\u0000"+
		"\u0000\u01a3\u01a4\u0003,\u0016\u0000\u01a4\u01a5\u0005&\u0000\u0000\u01a5"+
		"\u01a6\u00030\u0018\u0000\u01a6\u01a7\u0006\u0017\uffff\uffff\u0000\u01a7"+
		"\u01ae\u0001\u0000\u0000\u0000\u01a8\u01a9\u0003,\u0016\u0000\u01a9\u01aa"+
		"\u0005&\u0000\u0000\u01aa\u01ab\u0003.\u0017\u0002\u01ab\u01ac\u0006\u0017"+
		"\uffff\uffff\u0000\u01ac\u01ae\u0001\u0000\u0000\u0000\u01ad\u019f\u0001"+
		"\u0000\u0000\u0000\u01ad\u01a3\u0001\u0000\u0000\u0000\u01ad\u01a8\u0001"+
		"\u0000\u0000\u0000\u01ae\u01b4\u0001\u0000\u0000\u0000\u01af\u01b0\n\u0001"+
		"\u0000\u0000\u01b0\u01b1\u0005*\u0000\u0000\u01b1\u01b3\u0006\u0017\uffff"+
		"\uffff\u0000\u01b2\u01af\u0001\u0000\u0000\u0000\u01b3\u01b6\u0001\u0000"+
		"\u0000\u0000\u01b4\u01b2\u0001\u0000\u0000\u0000\u01b4\u01b5\u0001\u0000"+
		"\u0000\u0000\u01b5/\u0001\u0000\u0000\u0000\u01b6\u01b4\u0001\u0000\u0000"+
		"\u0000\u01b7\u01b8\u00032\u0019\u0000\u01b8\u01b9\u0006\u0018\uffff\uffff"+
		"\u0000\u01b9\u01c0\u0001\u0000\u0000\u0000\u01ba\u01bb\u00032\u0019\u0000"+
		"\u01bb\u01bc\u0005%\u0000\u0000\u01bc\u01bd\u00032\u0019\u0000\u01bd\u01be"+
		"\u0006\u0018\uffff\uffff\u0000\u01be\u01c0\u0001\u0000\u0000\u0000\u01bf"+
		"\u01b7\u0001\u0000\u0000\u0000\u01bf\u01ba\u0001\u0000\u0000\u0000\u01c0"+
		"1\u0001\u0000\u0000\u0000\u01c1\u01c2\u00034\u001a\u0000\u01c2\u01c3\u0006"+
		"\u0019\uffff\uffff\u0000\u01c3\u01ca\u0001\u0000\u0000\u0000\u01c4\u01c5"+
		"\u00034\u001a\u0000\u01c5\u01c6\u0005$\u0000\u0000\u01c6\u01c7\u00034"+
		"\u001a\u0000\u01c7\u01c8\u0006\u0019\uffff\uffff\u0000\u01c8\u01ca\u0001"+
		"\u0000\u0000\u0000\u01c9\u01c1\u0001\u0000\u0000\u0000\u01c9\u01c4\u0001"+
		"\u0000\u0000\u0000\u01ca3\u0001\u0000\u0000\u0000\u01cb\u01cc\u0006\u001a"+
		"\uffff\uffff\u0000\u01cc\u01cd\u00036\u001b\u0000\u01cd\u01ce\u0006\u001a"+
		"\uffff\uffff\u0000\u01ce\u01d6\u0001\u0000\u0000\u0000\u01cf\u01d0\n\u0001"+
		"\u0000\u0000\u01d0\u01d1\u0005\u001e\u0000\u0000\u01d1\u01d2\u00036\u001b"+
		"\u0000\u01d2\u01d3\u0006\u001a\uffff\uffff\u0000\u01d3\u01d5\u0001\u0000"+
		"\u0000\u0000\u01d4\u01cf\u0001\u0000\u0000\u0000\u01d5\u01d8\u0001\u0000"+
		"\u0000\u0000\u01d6\u01d4\u0001\u0000\u0000\u0000\u01d6\u01d7\u0001\u0000"+
		"\u0000\u0000\u01d75\u0001\u0000\u0000\u0000\u01d8\u01d6\u0001\u0000\u0000"+
		"\u0000\u01d9\u01da\u0006\u001b\uffff\uffff\u0000\u01da\u01db\u00038\u001c"+
		"\u0000\u01db\u01dc\u0006\u001b\uffff\uffff\u0000\u01dc\u01e0\u0001\u0000"+
		"\u0000\u0000\u01dd\u01de\u0005&\u0000\u0000\u01de\u01e0\u0006\u001b\uffff"+
		"\uffff\u0000\u01df\u01d9\u0001\u0000\u0000\u0000\u01df\u01dd\u0001\u0000"+
		"\u0000\u0000\u01e0\u01e8\u0001\u0000\u0000\u0000\u01e1\u01e2\n\u0002\u0000"+
		"\u0000\u01e2\u01e3\u0005 \u0000\u0000\u01e3\u01e4\u00038\u001c\u0000\u01e4"+
		"\u01e5\u0006\u001b\uffff\uffff\u0000\u01e5\u01e7\u0001\u0000\u0000\u0000"+
		"\u01e6\u01e1\u0001\u0000\u0000\u0000\u01e7\u01ea\u0001\u0000\u0000\u0000"+
		"\u01e8\u01e6\u0001\u0000\u0000\u0000\u01e8\u01e9\u0001\u0000\u0000\u0000"+
		"\u01e97\u0001\u0000\u0000\u0000\u01ea\u01e8\u0001\u0000\u0000\u0000\u01eb"+
		"\u01ec\u0005\u001e\u0000\u0000\u01ec\u01ed\u00038\u001c\u0000\u01ed\u01ee"+
		"\u0006\u001c\uffff\uffff\u0000\u01ee\u01f7\u0001\u0000\u0000\u0000\u01ef"+
		"\u01f0\u0005#\u0000\u0000\u01f0\u01f1\u00038\u001c\u0000\u01f1\u01f2\u0006"+
		"\u001c\uffff\uffff\u0000\u01f2\u01f7\u0001\u0000\u0000\u0000\u01f3\u01f4"+
		"\u0003:\u001d\u0000\u01f4\u01f5\u0006\u001c\uffff\uffff\u0000\u01f5\u01f7"+
		"\u0001\u0000\u0000\u0000\u01f6\u01eb\u0001\u0000\u0000\u0000\u01f6\u01ef"+
		"\u0001\u0000\u0000\u0000\u01f6\u01f3\u0001\u0000\u0000\u0000\u01f79\u0001"+
		"\u0000\u0000\u0000\u01f8\u01f9\u0003,\u0016\u0000\u01f9\u01fa\u0006\u001d"+
		"\uffff\uffff\u0000\u01fa\u0213\u0001\u0000\u0000\u0000\u01fb\u01fc\u0005"+
		"\'\u0000\u0000\u01fc\u01fd\u0005\u0015\u0000\u0000\u01fd\u01fe\u0003<"+
		"\u001e\u0000\u01fe\u01ff\u0005\u0016\u0000\u0000\u01ff\u0200\u0006\u001d"+
		"\uffff\uffff\u0000\u0200\u0213\u0001\u0000\u0000\u0000\u0201\u0202\u0005"+
		"\u0015\u0000\u0000\u0202\u0203\u0003.\u0017\u0000\u0203\u0204\u0005\u0016"+
		"\u0000\u0000\u0204\u0205\u0006\u001d\uffff\uffff\u0000\u0205\u0213\u0001"+
		"\u0000\u0000\u0000\u0206\u0207\u0005(\u0000\u0000\u0207\u0213\u0006\u001d"+
		"\uffff\uffff\u0000\u0208\u0209\u0005)\u0000\u0000\u0209\u0213\u0006\u001d"+
		"\uffff\uffff\u0000\u020a\u020b\u0003,\u0016\u0000\u020b\u020c\u0005!\u0000"+
		"\u0000\u020c\u020d\u0006\u001d\uffff\uffff\u0000\u020d\u0213\u0001\u0000"+
		"\u0000\u0000\u020e\u020f\u0003,\u0016\u0000\u020f\u0210\u0005\"\u0000"+
		"\u0000\u0210\u0211\u0006\u001d\uffff\uffff\u0000\u0211\u0213\u0001\u0000"+
		"\u0000\u0000\u0212\u01f8\u0001\u0000\u0000\u0000\u0212\u01fb\u0001\u0000"+
		"\u0000\u0000\u0212\u0201\u0001\u0000\u0000\u0000\u0212\u0206\u0001\u0000"+
		"\u0000\u0000\u0212\u0208\u0001\u0000\u0000\u0000\u0212\u020a\u0001\u0000"+
		"\u0000\u0000\u0212\u020e\u0001\u0000\u0000\u0000\u0213;\u0001\u0000\u0000"+
		"\u0000\u0214\u0215\u0003>\u001f\u0000\u0215\u0216\u0006\u001e\uffff\uffff"+
		"\u0000\u0216\u0219\u0001\u0000\u0000\u0000\u0217\u0219\u0001\u0000\u0000"+
		"\u0000\u0218\u0214\u0001\u0000\u0000\u0000\u0218\u0217\u0001\u0000\u0000"+
		"\u0000\u0219=\u0001\u0000\u0000\u0000\u021a\u021b\u0006\u001f\uffff\uffff"+
		"\u0000\u021b\u021c\u00030\u0018\u0000\u021c\u021d\u0006\u001f\uffff\uffff"+
		"\u0000\u021d\u0225\u0001\u0000\u0000\u0000\u021e\u021f\n\u0002\u0000\u0000"+
		"\u021f\u0220\u0005\u001c\u0000\u0000\u0220\u0221\u00030\u0018\u0000\u0221"+
		"\u0222\u0006\u001f\uffff\uffff\u0000\u0222\u0224\u0001\u0000\u0000\u0000"+
		"\u0223\u021e\u0001\u0000\u0000\u0000\u0224\u0227\u0001\u0000\u0000\u0000"+
		"\u0225\u0223\u0001\u0000\u0000\u0000\u0225\u0226\u0001\u0000\u0000\u0000"+
		"\u0226?\u0001\u0000\u0000\u0000\u0227\u0225\u0001\u0000\u0000\u0000 N"+
		"`q\u0087\u0091\u00a1\u00a3\u00b0\u00c8\u00d4\u00e7\u00f1\u0102\u0104\u0111"+
		"\u016a\u0170\u0179\u018b\u0193\u019d\u01ad\u01b4\u01bf\u01c9\u01d6\u01df"+
		"\u01e8\u01f6\u0212\u0218\u0225";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}