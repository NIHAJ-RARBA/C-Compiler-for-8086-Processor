# C Compiler for 8086 Processor

A comprehensive C compiler implementation targeting the 8086 processor architecture, developed as part of CSE310 coursework. This project implements a complete compilation pipeline from source code to intermediate code generation with optimization capabilities.

Each segment of the compiler is built in accordance with the specifications given
in the coursework, and extended beyond that during development.

Further improvements such as Struct and Union support as well as more complex syntax grammars are planned.

## 🏗️ Project Architecture

The compiler is structured into four main phases, each building upon the previous one:

### 1️⃣ Symbol Table (`1_symbolTable/`)
**Foundation Phase**: Implements efficient symbol management using advanced hashing techniques.

- **Hash Functions**: Multiple hash implementations (SDBM, Jenkins, Polynomial Rolling, MurmurHash3)
- **Scope Management**: Hierarchical scope handling with collision resolution
- **Performance Analysis**: Comprehensive statistics tracking for hash function performance
- **Rehashing Support**: Dynamic table resizing for optimal performance

**Key Features:**
- 4 different hash function implementations with performance comparison
- Collision handling with separate chaining
- Scope-based symbol table stack management
- Detailed performance reporting and analysis

### 2️⃣ Lexical Analyzer (`2_lexicalAnalyzer/`)
**Tokenization Phase**: Converts source code into meaningful tokens using Flex.

- **Flex-based Lexer**: Comprehensive lexical analysis using `.l` specification
- **Token Stream Generation**: Produces detailed token streams for parser consumption
- **Error Handling**: Robust error detection and reporting for lexical errors
- **Symbol Integration**: Seamless integration with symbol table from Phase 1

**Key Features:**
- Complete C language token recognition
- String and character literal handling
- Comment processing (single-line and multi-line)
- Error logging with line number tracking
- Token stream output for debugging

### 3️⃣ Syntax & Semantic Analyzer (`3_ssanalyzer/`)
**Parsing Phase**: Implements syntax analysis and semantic checking using ANTLR4.

- **ANTLR4 Grammar**: Complete C language grammar specification
- **Parse Tree Generation**: Abstract syntax tree construction
- **Semantic Analysis**: Type checking, scope validation, and semantic error detection
- **Cross-Platform Support**: Both C++ and Java implementations available

**Key Features:**
- Complete C grammar with ANTLR4
- Syntax error detection and recovery
- Semantic analysis with type checking
- Symbol table integration for scope management
- Parse tree visualization capabilities

### 4️⃣ Intermediate Code Generator (`4_icg/`)
**Code Generation Phase**: Generates optimized intermediate code for 8086 architecture.

- **8086 Assembly Generation**: Produces assembly code targeting 8086 processor
- **Code Optimization**: Multiple optimization passes to improve generated code
- **Register Management**: Efficient register allocation and management
- **Control Flow**: Proper handling of loops, conditionals, and function calls

**Key Features:**
- 8086-specific intermediate code generation
- Code optimization techniques (dead code elimination, constant folding)
- Assembly output with proper 8086 instruction set
- Performance optimization for target architecture

## 🚀 Getting Started

### Prerequisites
- **C++ Compiler**: GCC with C++17 support
- **ANTLR4**: Version 4.13.2 or later
- **Flex**: For lexical analysis
- **Make**: For build automation

### Installation & Build

1. **Clone the repository:**
```bash
git clone https://github.com/NIHAJ-RARBA/C-Compiler-for-8086-Processor.git
cd C-Compiler-for-8086-Processor
```

2. **Build each phase:**

**Phase 1 - Symbol Table:**
```bash
cd 1_symbolTable
chmod +x run.sh
./run.sh
```

**Phase 2 - Lexical Analyzer:**
```bash
cd 2_lexicalAnalyzer
make
./main.out input.c
```

**Phase 3 - Syntax & Semantic Analyzer:**
```bash
cd 3_ssanalyzer/2105055_ssanalyzer
chmod +x run-script.sh
./run-script.sh input.c
```

**Phase 4 - Intermediate Code Generator:**
```bash
cd 4_icg
chmod +x run-script.sh
./run-script.sh input.c
```

## 📁 Directory Structure

```
C-Compiler-for-8086-Processor/
├── 1_symbolTable/           # Symbol table implementation with hash functions
│   ├── main.cpp            # Main symbol table driver
│   ├── SymbolTable.cpp     # Core symbol table implementation
│   ├── ScopeTable.cpp      # Scope management
│   ├── HashFunctions.cpp   # Multiple hash function implementations
│   ├── MurMurHash3.cpp     # MurmurHash3 implementation
│   └── generate_report.cpp # Performance analysis generator
├── 2_lexicalAnalyzer/      # Flex-based lexical analyzer
│   ├── 2105055.l          # Flex specification file
│   ├── Makefile           # Build configuration
│   └── header/            # Symbol table headers (reused from Phase 1)
├── 3_ssanalyzer/          # ANTLR4-based syntax and semantic analyzer
│   ├── 2105055_ssanalyzer/
│   │   ├── C2105055Lexer.g4    # ANTLR4 lexer grammar
│   │   ├── C2105055Parser.g4   # ANTLR4 parser grammar
│   │   ├── Ctester.cpp         # Main parser driver
│   │   └── headers/            # Symbol table integration
│   └── antlr4-resources/       # ANTLR4 setup and examples
└── 4_icg/                 # Intermediate code generator
    ├── 2105055_icg_optimizer.cpp  # Code optimization engine
    ├── C2105055Lexer.g4          # Lexer for code generation
    ├── C2105055Parser.g4         # Parser for code generation
    ├── Ctester.cpp               # Main ICG driver
    └── input/                    # Test programs and examples
```

## 🧪 Testing

Each phase includes comprehensive test cases:

- **Symbol Table**: Hash function performance tests and collision analysis
- **Lexical Analyzer**: C language tokenization tests with error cases
- **Parser**: Syntax and semantic analysis tests with various C constructs
- **Code Generator**: 8086 assembly generation tests with optimization verification

### Running Tests

```bash
# Test symbol table with various inputs
cd 1_symbolTable && ./run.sh

# Test lexical analyzer
cd 2_lexicalAnalyzer && make && ./main.out TEST/input1.txt

# Test parser with sample programs
cd 3_ssanalyzer/2105055_ssanalyzer && ./run-script.sh input/input1.txt

# Test code generation
cd 4_icg && ./run-script.sh input/test1_i.c
```

## 🔧 Technical Highlights

### Advanced Hashing (Phase 1)
- **4 Hash Functions**: SDBM, Jenkins, Polynomial Rolling, MurmurHash3
- **Performance Metrics**: Collision analysis, load factor tracking, chain length statistics
- **Dynamic Resizing**: Automatic table resizing based on load factor

### Robust Lexical Analysis (Phase 2)
- **Complete C Lexicon**: All C keywords, operators, and literals supported
- **Error Recovery**: Intelligent error handling with continued parsing
- **Token Attribution**: Line numbers, lexeme values, and token types

### Comprehensive Parsing (Phase 3)
- **Full C Grammar**: Complete C language syntax support
- **Semantic Checks**: Type compatibility, scope validation, function signature matching
- **Error Reporting**: Detailed error messages with context information

### Optimized Code Generation (Phase 4)
- **8086 Target**: Specialized for 8086 processor architecture
- **Optimization Passes**: Dead code elimination, constant propagation, register optimization
- **Assembly Output**: Human-readable and assembler-ready output

## 📊 Performance Analysis

The compiler includes built-in performance analysis tools:

- **Hash Function Comparison**: Detailed statistics on collision rates and performance
- **Parse Time Analysis**: Timing information for different parsing phases
- **Code Quality Metrics**: Analysis of generated code efficiency

## 🤝 Contributing

This project was developed as part of academic coursework. The implementation follows standard compiler design principles and includes comprehensive documentation for educational purposes.

## 📄 License

This project is developed for educational purposes as part of CSE310 coursework.

## 🏆 Acknowledgments

- **Hash Functions**: Multiple hash function implementations with proper attribution
- **ANTLR4**: Powerful parser generator framework
- **8086 Architecture**: Classic processor architecture for educational compiler development
- **Academic Resources**: CSE310 course materials and specifications

---

**Author**: NIHAJ RARBA  
**Course**: CSE310 - Compiler Design  
**Target Architecture**: Intel 8086 Processor  
**Development Language**: C++ with ANTLR4 and Flex
