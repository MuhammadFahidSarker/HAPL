// Generated from D:/Study/CUHK/Year 2 Term 1/CSCI 2100/HAPL/src/com/fsapps/HAPL\HAPL.g4 by ANTLR 4.9.2
package com.fsapps.HAPL;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class HAPLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, MAIN_TAG_START=9, 
		MAIN_TAG_END=10, OUT=11, INPUT=12, Null=13, Return=14, Assert=15, Size=16, 
		In=17, Or=18, And=19, Equals=20, NEquals=21, GTEquals=22, LTEquals=23, 
		Pow=24, Excl=25, GT=26, LT=27, Add=28, Subtract=29, Multiply=30, Divide=31, 
		Modulus=32, OBrace=33, CBrace=34, OBracket=35, CBracket=36, OParen=37, 
		CParen=38, SColon=39, Assign=40, Comma=41, QMark=42, Colon=43, Bool=44, 
		Number=45, Identifier=46, String=47, Comment=48, Space=49;
	public static final int
		RULE_parse = 0, RULE_block = 1, RULE_functionDecl = 2, RULE_functionParam = 3, 
		RULE_idList = 4, RULE_statement = 5, RULE_repeatStatement = 6, RULE_repeatWhile = 7, 
		RULE_repeatWithVar = 8, RULE_repeatFrom = 9, RULE_repeatTo = 10, RULE_repeatStep = 11, 
		RULE_repeatFixed = 12, RULE_assignment = 13, RULE_ifStatement = 14, RULE_ifStat = 15, 
		RULE_elseIfStat = 16, RULE_elseStat = 17, RULE_functionCall = 18, RULE_expression = 19, 
		RULE_indexes = 20, RULE_list = 21, RULE_exprList = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "block", "functionDecl", "functionParam", "idList", "statement", 
			"repeatStatement", "repeatWhile", "repeatWithVar", "repeatFrom", "repeatTo", 
			"repeatStep", "repeatFixed", "assignment", "ifStatement", "ifStat", "elseIfStat", 
			"elseStat", "functionCall", "expression", "indexes", "list", "exprList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'repeat'", "'while'", "'<if'", "'</if>'", "'<elif'", "'</elif>'", 
			"'<else>'", "'</else>'", null, null, "'out'", "'inp'", "'null'", "'return'", 
			"'assert'", "'size'", "'in'", "'||'", "'&&'", "'=='", "'!='", "'>='", 
			"'<='", "'^'", "'!'", "'>'", "'<'", "'+'", "'-'", "'*'", "'/'", "'%'", 
			"'{'", "'}'", "'['", "']'", "'('", "')'", "';'", "'='", "','", "'?'", 
			"':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "MAIN_TAG_START", 
			"MAIN_TAG_END", "OUT", "INPUT", "Null", "Return", "Assert", "Size", "In", 
			"Or", "And", "Equals", "NEquals", "GTEquals", "LTEquals", "Pow", "Excl", 
			"GT", "LT", "Add", "Subtract", "Multiply", "Divide", "Modulus", "OBrace", 
			"CBrace", "OBracket", "CBracket", "OParen", "CParen", "SColon", "Assign", 
			"Comma", "QMark", "Colon", "Bool", "Number", "Identifier", "String", 
			"Comment", "Space"
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
	public String getGrammarFileName() { return "HAPL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HAPLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ParseContext extends ParserRuleContext {
		public TerminalNode MAIN_TAG_START() { return getToken(HAPLParser.MAIN_TAG_START, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode MAIN_TAG_END() { return getToken(HAPLParser.MAIN_TAG_END, 0); }
		public TerminalNode EOF() { return getToken(HAPLParser.EOF, 0); }
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(MAIN_TAG_START);
			setState(47);
			block();
			setState(48);
			match(MAIN_TAG_END);
			setState(49);
			match(EOF);
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

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public TerminalNode Return() { return getToken(HAPLParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SColon() { return getToken(HAPLParser.SColon, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(53);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						setState(51);
						statement();
						}
						break;
					case 2:
						{
						setState(52);
						functionDecl();
						}
						break;
					}
					} 
				}
				setState(57);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Return) {
				{
				setState(58);
				match(Return);
				setState(59);
				expression(0);
				setState(60);
				match(SColon);
				}
			}

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

	public static class FunctionDeclContext extends ParserRuleContext {
		public List<TerminalNode> LT() { return getTokens(HAPLParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(HAPLParser.LT, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(HAPLParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(HAPLParser.Identifier, i);
		}
		public List<TerminalNode> GT() { return getTokens(HAPLParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(HAPLParser.GT, i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode Divide() { return getToken(HAPLParser.Divide, 0); }
		public FunctionParamContext functionParam() {
			return getRuleContext(FunctionParamContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(LT);
			setState(65);
			match(Identifier);
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(66);
				functionParam();
				}
				break;
			}
			setState(69);
			match(GT);
			setState(70);
			block();
			setState(71);
			match(LT);
			setState(72);
			match(Divide);
			setState(73);
			match(Identifier);
			setState(74);
			match(GT);
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

	public static class FunctionParamContext extends ParserRuleContext {
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public FunctionParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionParam; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitFunctionParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionParamContext functionParam() throws RecognitionException {
		FunctionParamContext _localctx = new FunctionParamContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(76);
				idList();
				}
			}

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

	public static class IdListContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(HAPLParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(HAPLParser.Identifier, i);
		}
		public List<TerminalNode> Comma() { return getTokens(HAPLParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(HAPLParser.Comma, i);
		}
		public IdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitIdList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdListContext idList() throws RecognitionException {
		IdListContext _localctx = new IdListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_idList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(Identifier);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(80);
				match(Comma);
				setState(81);
				match(Identifier);
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public RepeatStatementContext repeatStatement() {
			return getRuleContext(RepeatStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		try {
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				functionCall();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
				ifStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(90);
				repeatStatement();
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

	public static class RepeatStatementContext extends ParserRuleContext {
		public RepeatFixedContext repeatFixed() {
			return getRuleContext(RepeatFixedContext.class,0);
		}
		public RepeatWithVarContext repeatWithVar() {
			return getRuleContext(RepeatWithVarContext.class,0);
		}
		public RepeatWhileContext repeatWhile() {
			return getRuleContext(RepeatWhileContext.class,0);
		}
		public RepeatStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitRepeatStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatStatementContext repeatStatement() throws RecognitionException {
		RepeatStatementContext _localctx = new RepeatStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_repeatStatement);
		try {
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				repeatFixed();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				repeatWithVar();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(95);
				repeatWhile();
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

	public static class RepeatWhileContext extends ParserRuleContext {
		public List<TerminalNode> LT() { return getTokens(HAPLParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(HAPLParser.LT, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> GT() { return getTokens(HAPLParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(HAPLParser.GT, i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode Divide() { return getToken(HAPLParser.Divide, 0); }
		public RepeatWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatWhile; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitRepeatWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatWhileContext repeatWhile() throws RecognitionException {
		RepeatWhileContext _localctx = new RepeatWhileContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_repeatWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(LT);
			setState(99);
			match(T__0);
			setState(100);
			match(T__1);
			setState(101);
			expression(0);
			setState(102);
			match(GT);
			setState(103);
			block();
			setState(104);
			match(LT);
			setState(105);
			match(Divide);
			setState(106);
			match(T__0);
			setState(107);
			match(GT);
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

	public static class RepeatWithVarContext extends ParserRuleContext {
		public List<TerminalNode> LT() { return getTokens(HAPLParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(HAPLParser.LT, i);
		}
		public TerminalNode Identifier() { return getToken(HAPLParser.Identifier, 0); }
		public RepeatFromContext repeatFrom() {
			return getRuleContext(RepeatFromContext.class,0);
		}
		public RepeatToContext repeatTo() {
			return getRuleContext(RepeatToContext.class,0);
		}
		public List<TerminalNode> GT() { return getTokens(HAPLParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(HAPLParser.GT, i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode Divide() { return getToken(HAPLParser.Divide, 0); }
		public RepeatStepContext repeatStep() {
			return getRuleContext(RepeatStepContext.class,0);
		}
		public RepeatWithVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatWithVar; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitRepeatWithVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatWithVarContext repeatWithVar() throws RecognitionException {
		RepeatWithVarContext _localctx = new RepeatWithVarContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_repeatWithVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(LT);
			setState(110);
			match(T__0);
			setState(111);
			match(Identifier);
			setState(112);
			repeatFrom();
			setState(113);
			repeatTo();
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Comma) {
				{
				setState(114);
				repeatStep();
				}
			}

			setState(117);
			match(GT);
			setState(118);
			block();
			setState(119);
			match(LT);
			setState(120);
			match(Divide);
			setState(121);
			match(T__0);
			setState(122);
			match(GT);
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

	public static class RepeatFromContext extends ParserRuleContext {
		public TerminalNode Comma() { return getToken(HAPLParser.Comma, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RepeatFromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatFrom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitRepeatFrom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatFromContext repeatFrom() throws RecognitionException {
		RepeatFromContext _localctx = new RepeatFromContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_repeatFrom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(Comma);
			setState(125);
			expression(0);
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

	public static class RepeatToContext extends ParserRuleContext {
		public TerminalNode Comma() { return getToken(HAPLParser.Comma, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RepeatToContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatTo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitRepeatTo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatToContext repeatTo() throws RecognitionException {
		RepeatToContext _localctx = new RepeatToContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_repeatTo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(Comma);
			setState(128);
			expression(0);
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

	public static class RepeatStepContext extends ParserRuleContext {
		public TerminalNode Comma() { return getToken(HAPLParser.Comma, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RepeatStepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatStep; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitRepeatStep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatStepContext repeatStep() throws RecognitionException {
		RepeatStepContext _localctx = new RepeatStepContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_repeatStep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(Comma);
			setState(131);
			expression(0);
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

	public static class RepeatFixedContext extends ParserRuleContext {
		public List<TerminalNode> LT() { return getTokens(HAPLParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(HAPLParser.LT, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> GT() { return getTokens(HAPLParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(HAPLParser.GT, i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode Divide() { return getToken(HAPLParser.Divide, 0); }
		public RepeatFixedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatFixed; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitRepeatFixed(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatFixedContext repeatFixed() throws RecognitionException {
		RepeatFixedContext _localctx = new RepeatFixedContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_repeatFixed);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(LT);
			setState(134);
			match(T__0);
			setState(135);
			expression(0);
			setState(136);
			match(GT);
			setState(137);
			block();
			setState(138);
			match(LT);
			setState(139);
			match(Divide);
			setState(140);
			match(T__0);
			setState(141);
			match(GT);
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(HAPLParser.LT, 0); }
		public TerminalNode Identifier() { return getToken(HAPLParser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(HAPLParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Divide() { return getToken(HAPLParser.Divide, 0); }
		public TerminalNode GT() { return getToken(HAPLParser.GT, 0); }
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(LT);
			setState(144);
			match(Identifier);
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OBracket) {
				{
				setState(145);
				indexes();
				}
			}

			setState(148);
			match(Assign);
			setState(149);
			expression(0);
			setState(150);
			match(Divide);
			setState(151);
			match(GT);
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

	public static class IfStatementContext extends ParserRuleContext {
		public IfStatContext ifStat() {
			return getRuleContext(IfStatContext.class,0);
		}
		public List<ElseIfStatContext> elseIfStat() {
			return getRuleContexts(ElseIfStatContext.class);
		}
		public ElseIfStatContext elseIfStat(int i) {
			return getRuleContext(ElseIfStatContext.class,i);
		}
		public ElseStatContext elseStat() {
			return getRuleContext(ElseStatContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			ifStat();
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(154);
				elseIfStat();
				}
				}
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(160);
				elseStat();
				}
			}

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

	public static class IfStatContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode GT() { return getToken(HAPLParser.GT, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(T__2);
			setState(164);
			expression(0);
			setState(165);
			match(GT);
			setState(166);
			block();
			setState(167);
			match(T__3);
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

	public static class ElseIfStatContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode GT() { return getToken(HAPLParser.GT, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseIfStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfStat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitElseIfStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseIfStatContext elseIfStat() throws RecognitionException {
		ElseIfStatContext _localctx = new ElseIfStatContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_elseIfStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(T__4);
			setState(170);
			expression(0);
			setState(171);
			match(GT);
			setState(172);
			block();
			setState(173);
			match(T__5);
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

	public static class ElseStatContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitElseStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatContext elseStat() throws RecognitionException {
		ElseStatContext _localctx = new ElseStatContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_elseStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(T__6);
			setState(176);
			block();
			setState(177);
			match(T__7);
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

	public static class FunctionCallContext extends ParserRuleContext {
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
	 
		public FunctionCallContext() { }
		public void copyFrom(FunctionCallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssertFunctionCallContext extends FunctionCallContext {
		public TerminalNode LT() { return getToken(HAPLParser.LT, 0); }
		public TerminalNode Assert() { return getToken(HAPLParser.Assert, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Divide() { return getToken(HAPLParser.Divide, 0); }
		public TerminalNode GT() { return getToken(HAPLParser.GT, 0); }
		public AssertFunctionCallContext(FunctionCallContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitAssertFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SizeFunctionCallContext extends FunctionCallContext {
		public TerminalNode LT() { return getToken(HAPLParser.LT, 0); }
		public TerminalNode Size() { return getToken(HAPLParser.Size, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Divide() { return getToken(HAPLParser.Divide, 0); }
		public TerminalNode GT() { return getToken(HAPLParser.GT, 0); }
		public SizeFunctionCallContext(FunctionCallContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitSizeFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TakeInputFunctionCallContext extends FunctionCallContext {
		public TerminalNode LT() { return getToken(HAPLParser.LT, 0); }
		public TerminalNode INPUT() { return getToken(HAPLParser.INPUT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Divide() { return getToken(HAPLParser.Divide, 0); }
		public TerminalNode GT() { return getToken(HAPLParser.GT, 0); }
		public TakeInputFunctionCallContext(FunctionCallContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitTakeInputFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierFunctionCallContext extends FunctionCallContext {
		public TerminalNode LT() { return getToken(HAPLParser.LT, 0); }
		public TerminalNode Identifier() { return getToken(HAPLParser.Identifier, 0); }
		public TerminalNode Divide() { return getToken(HAPLParser.Divide, 0); }
		public TerminalNode GT() { return getToken(HAPLParser.GT, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public IdentifierFunctionCallContext(FunctionCallContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitIdentifierFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintFunctionCallContext extends FunctionCallContext {
		public TerminalNode LT() { return getToken(HAPLParser.LT, 0); }
		public TerminalNode OUT() { return getToken(HAPLParser.OUT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Divide() { return getToken(HAPLParser.Divide, 0); }
		public TerminalNode GT() { return getToken(HAPLParser.GT, 0); }
		public PrintFunctionCallContext(FunctionCallContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitPrintFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_functionCall);
		int _la;
		try {
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new IdentifierFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				match(LT);
				setState(180);
				match(Identifier);
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << Excl) | (1L << LT) | (1L << Subtract) | (1L << OBracket) | (1L << OParen) | (1L << Bool) | (1L << Number) | (1L << Identifier) | (1L << String))) != 0)) {
					{
					setState(181);
					exprList();
					}
				}

				setState(184);
				match(Divide);
				setState(185);
				match(GT);
				}
				break;
			case 2:
				_localctx = new PrintFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				match(LT);
				setState(187);
				match(OUT);
				setState(188);
				expression(0);
				setState(189);
				match(Divide);
				setState(190);
				match(GT);
				}
				break;
			case 3:
				_localctx = new AssertFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				match(LT);
				setState(193);
				match(Assert);
				setState(194);
				expression(0);
				setState(195);
				match(Divide);
				setState(196);
				match(GT);
				}
				break;
			case 4:
				_localctx = new SizeFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(198);
				match(LT);
				setState(199);
				match(Size);
				setState(200);
				expression(0);
				setState(201);
				match(Divide);
				setState(202);
				match(GT);
				}
				break;
			case 5:
				_localctx = new TakeInputFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(204);
				match(LT);
				setState(205);
				match(INPUT);
				setState(206);
				expression(0);
				setState(207);
				match(Divide);
				setState(208);
				match(GT);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BoolExpressionContext extends ExpressionContext {
		public TerminalNode Bool() { return getToken(HAPLParser.Bool, 0); }
		public BoolExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitBoolExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberExpressionContext extends ExpressionContext {
		public TerminalNode Number() { return getToken(HAPLParser.Number, 0); }
		public NumberExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitNumberExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierExpressionContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(HAPLParser.Identifier, 0); }
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public IdentifierExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitIdentifierExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExpressionContext extends ExpressionContext {
		public TerminalNode Excl() { return getToken(HAPLParser.Excl, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitNotExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Or() { return getToken(HAPLParser.Or, 0); }
		public OrExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryMinusExpressionContext extends ExpressionContext {
		public TerminalNode Subtract() { return getToken(HAPLParser.Subtract, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryMinusExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitUnaryMinusExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PowerExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Pow() { return getToken(HAPLParser.Pow, 0); }
		public PowerExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitPowerExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Equals() { return getToken(HAPLParser.Equals, 0); }
		public TerminalNode NEquals() { return getToken(HAPLParser.NEquals, 0); }
		public EqExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitEqExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode And() { return getToken(HAPLParser.And, 0); }
		public AndExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode In() { return getToken(HAPLParser.In, 0); }
		public InExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitInExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringExpressionContext extends ExpressionContext {
		public TerminalNode String() { return getToken(HAPLParser.String, 0); }
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public StringExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitStringExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionExpressionContext extends ExpressionContext {
		public TerminalNode OParen() { return getToken(HAPLParser.OParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CParen() { return getToken(HAPLParser.CParen, 0); }
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public ExpressionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitExpressionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Add() { return getToken(HAPLParser.Add, 0); }
		public TerminalNode Subtract() { return getToken(HAPLParser.Subtract, 0); }
		public AddExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitAddExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GTEquals() { return getToken(HAPLParser.GTEquals, 0); }
		public TerminalNode LTEquals() { return getToken(HAPLParser.LTEquals, 0); }
		public TerminalNode GT() { return getToken(HAPLParser.GT, 0); }
		public TerminalNode LT() { return getToken(HAPLParser.LT, 0); }
		public CompExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitCompExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullExpressionContext extends ExpressionContext {
		public TerminalNode Null() { return getToken(HAPLParser.Null, 0); }
		public NullExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitNullExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallExpressionContext extends ExpressionContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public FunctionCallExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitFunctionCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Multiply() { return getToken(HAPLParser.Multiply, 0); }
		public TerminalNode Divide() { return getToken(HAPLParser.Divide, 0); }
		public TerminalNode Modulus() { return getToken(HAPLParser.Modulus, 0); }
		public MultExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitMultExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListExpressionContext extends ExpressionContext {
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public IndexesContext indexes() {
			return getRuleContext(IndexesContext.class,0);
		}
		public ListExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitListExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TernaryExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode QMark() { return getToken(HAPLParser.QMark, 0); }
		public TerminalNode Colon() { return getToken(HAPLParser.Colon, 0); }
		public TernaryExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitTernaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Subtract:
				{
				_localctx = new UnaryMinusExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(213);
				match(Subtract);
				setState(214);
				expression(19);
				}
				break;
			case Excl:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(215);
				match(Excl);
				setState(216);
				expression(18);
				}
				break;
			case Number:
				{
				_localctx = new NumberExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217);
				match(Number);
				}
				break;
			case Bool:
				{
				_localctx = new BoolExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(218);
				match(Bool);
				}
				break;
			case Null:
				{
				_localctx = new NullExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(219);
				match(Null);
				}
				break;
			case LT:
				{
				_localctx = new FunctionCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(220);
				functionCall();
				setState(222);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(221);
					indexes();
					}
					break;
				}
				}
				break;
			case OBracket:
				{
				_localctx = new ListExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(224);
				list();
				setState(226);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(225);
					indexes();
					}
					break;
				}
				}
				break;
			case Identifier:
				{
				_localctx = new IdentifierExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(228);
				match(Identifier);
				setState(230);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(229);
					indexes();
					}
					break;
				}
				}
				break;
			case String:
				{
				_localctx = new StringExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(232);
				match(String);
				setState(234);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(233);
					indexes();
					}
					break;
				}
				}
				break;
			case OParen:
				{
				_localctx = new ExpressionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(236);
				match(OParen);
				setState(237);
				expression(0);
				setState(238);
				match(CParen);
				setState(240);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(239);
					indexes();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(276);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(274);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new PowerExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(244);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(245);
						match(Pow);
						setState(246);
						expression(17);
						}
						break;
					case 2:
						{
						_localctx = new MultExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(247);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(248);
						((MultExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Multiply) | (1L << Divide) | (1L << Modulus))) != 0)) ) {
							((MultExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(249);
						expression(17);
						}
						break;
					case 3:
						{
						_localctx = new AddExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(250);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(251);
						((AddExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Add || _la==Subtract) ) {
							((AddExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(252);
						expression(16);
						}
						break;
					case 4:
						{
						_localctx = new CompExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(253);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(254);
						((CompExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GTEquals) | (1L << LTEquals) | (1L << GT) | (1L << LT))) != 0)) ) {
							((CompExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(255);
						expression(15);
						}
						break;
					case 5:
						{
						_localctx = new EqExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(256);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(257);
						((EqExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Equals || _la==NEquals) ) {
							((EqExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(258);
						expression(14);
						}
						break;
					case 6:
						{
						_localctx = new AndExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(259);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(260);
						match(And);
						setState(261);
						expression(13);
						}
						break;
					case 7:
						{
						_localctx = new OrExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(262);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(263);
						match(Or);
						setState(264);
						expression(12);
						}
						break;
					case 8:
						{
						_localctx = new TernaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(265);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(266);
						match(QMark);
						setState(267);
						expression(0);
						setState(268);
						match(Colon);
						setState(269);
						expression(11);
						}
						break;
					case 9:
						{
						_localctx = new InExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(271);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(272);
						match(In);
						setState(273);
						expression(10);
						}
						break;
					}
					} 
				}
				setState(278);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class IndexesContext extends ParserRuleContext {
		public List<TerminalNode> OBracket() { return getTokens(HAPLParser.OBracket); }
		public TerminalNode OBracket(int i) {
			return getToken(HAPLParser.OBracket, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> CBracket() { return getTokens(HAPLParser.CBracket); }
		public TerminalNode CBracket(int i) {
			return getToken(HAPLParser.CBracket, i);
		}
		public IndexesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexes; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitIndexes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexesContext indexes() throws RecognitionException {
		IndexesContext _localctx = new IndexesContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_indexes);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(283); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(279);
					match(OBracket);
					setState(280);
					expression(0);
					setState(281);
					match(CBracket);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(285); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class ListContext extends ParserRuleContext {
		public TerminalNode OBracket() { return getToken(HAPLParser.OBracket, 0); }
		public TerminalNode CBracket() { return getToken(HAPLParser.CBracket, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(OBracket);
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << Excl) | (1L << LT) | (1L << Subtract) | (1L << OBracket) | (1L << OParen) | (1L << Bool) | (1L << Number) | (1L << Identifier) | (1L << String))) != 0)) {
				{
				setState(288);
				exprList();
				}
			}

			setState(291);
			match(CBracket);
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

	public static class ExprListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(HAPLParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(HAPLParser.Comma, i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HAPLVisitor ) return ((HAPLVisitor<? extends T>)visitor).visitExprList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			expression(0);
			setState(298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(294);
				match(Comma);
				setState(295);
				expression(0);
				}
				}
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 19:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 17);
		case 1:
			return precpred(_ctx, 16);
		case 2:
			return precpred(_ctx, 15);
		case 3:
			return precpred(_ctx, 14);
		case 4:
			return precpred(_ctx, 13);
		case 5:
			return precpred(_ctx, 12);
		case 6:
			return precpred(_ctx, 11);
		case 7:
			return precpred(_ctx, 10);
		case 8:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\63\u0130\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\7\38\n\3\f\3\16\3;\13\3\3\3\3\3\3\3\3\3\5\3A\n\3\3"+
		"\4\3\4\3\4\5\4F\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\5\5P\n\5\3\6\3\6\3"+
		"\6\7\6U\n\6\f\6\16\6X\13\6\3\7\3\7\3\7\3\7\5\7^\n\7\3\b\3\b\3\b\5\bc\n"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\5\nv\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\5\17\u0095\n\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\7\20\u009e\n\20\f"+
		"\20\16\20\u00a1\13\20\3\20\5\20\u00a4\n\20\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\5"+
		"\24\u00b9\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\5\24\u00d5\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\5\25\u00e1\n\25\3\25\3\25\5\25\u00e5\n\25\3\25\3\25\5\25\u00e9\n\25\3"+
		"\25\3\25\5\25\u00ed\n\25\3\25\3\25\3\25\3\25\5\25\u00f3\n\25\5\25\u00f5"+
		"\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\7\25\u0115\n\25\f\25\16\25\u0118\13\25\3\26\3\26\3\26"+
		"\3\26\6\26\u011e\n\26\r\26\16\26\u011f\3\27\3\27\5\27\u0124\n\27\3\27"+
		"\3\27\3\30\3\30\3\30\7\30\u012b\n\30\f\30\16\30\u012e\13\30\3\30\2\3("+
		"\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\6\3\2 \"\3\2\36"+
		"\37\4\2\30\31\34\35\3\2\26\27\2\u0146\2\60\3\2\2\2\49\3\2\2\2\6B\3\2\2"+
		"\2\bO\3\2\2\2\nQ\3\2\2\2\f]\3\2\2\2\16b\3\2\2\2\20d\3\2\2\2\22o\3\2\2"+
		"\2\24~\3\2\2\2\26\u0081\3\2\2\2\30\u0084\3\2\2\2\32\u0087\3\2\2\2\34\u0091"+
		"\3\2\2\2\36\u009b\3\2\2\2 \u00a5\3\2\2\2\"\u00ab\3\2\2\2$\u00b1\3\2\2"+
		"\2&\u00d4\3\2\2\2(\u00f4\3\2\2\2*\u011d\3\2\2\2,\u0121\3\2\2\2.\u0127"+
		"\3\2\2\2\60\61\7\13\2\2\61\62\5\4\3\2\62\63\7\f\2\2\63\64\7\2\2\3\64\3"+
		"\3\2\2\2\658\5\f\7\2\668\5\6\4\2\67\65\3\2\2\2\67\66\3\2\2\28;\3\2\2\2"+
		"9\67\3\2\2\29:\3\2\2\2:@\3\2\2\2;9\3\2\2\2<=\7\20\2\2=>\5(\25\2>?\7)\2"+
		"\2?A\3\2\2\2@<\3\2\2\2@A\3\2\2\2A\5\3\2\2\2BC\7\35\2\2CE\7\60\2\2DF\5"+
		"\b\5\2ED\3\2\2\2EF\3\2\2\2FG\3\2\2\2GH\7\34\2\2HI\5\4\3\2IJ\7\35\2\2J"+
		"K\7!\2\2KL\7\60\2\2LM\7\34\2\2M\7\3\2\2\2NP\5\n\6\2ON\3\2\2\2OP\3\2\2"+
		"\2P\t\3\2\2\2QV\7\60\2\2RS\7+\2\2SU\7\60\2\2TR\3\2\2\2UX\3\2\2\2VT\3\2"+
		"\2\2VW\3\2\2\2W\13\3\2\2\2XV\3\2\2\2Y^\5\34\17\2Z^\5&\24\2[^\5\36\20\2"+
		"\\^\5\16\b\2]Y\3\2\2\2]Z\3\2\2\2][\3\2\2\2]\\\3\2\2\2^\r\3\2\2\2_c\5\32"+
		"\16\2`c\5\22\n\2ac\5\20\t\2b_\3\2\2\2b`\3\2\2\2ba\3\2\2\2c\17\3\2\2\2"+
		"de\7\35\2\2ef\7\3\2\2fg\7\4\2\2gh\5(\25\2hi\7\34\2\2ij\5\4\3\2jk\7\35"+
		"\2\2kl\7!\2\2lm\7\3\2\2mn\7\34\2\2n\21\3\2\2\2op\7\35\2\2pq\7\3\2\2qr"+
		"\7\60\2\2rs\5\24\13\2su\5\26\f\2tv\5\30\r\2ut\3\2\2\2uv\3\2\2\2vw\3\2"+
		"\2\2wx\7\34\2\2xy\5\4\3\2yz\7\35\2\2z{\7!\2\2{|\7\3\2\2|}\7\34\2\2}\23"+
		"\3\2\2\2~\177\7+\2\2\177\u0080\5(\25\2\u0080\25\3\2\2\2\u0081\u0082\7"+
		"+\2\2\u0082\u0083\5(\25\2\u0083\27\3\2\2\2\u0084\u0085\7+\2\2\u0085\u0086"+
		"\5(\25\2\u0086\31\3\2\2\2\u0087\u0088\7\35\2\2\u0088\u0089\7\3\2\2\u0089"+
		"\u008a\5(\25\2\u008a\u008b\7\34\2\2\u008b\u008c\5\4\3\2\u008c\u008d\7"+
		"\35\2\2\u008d\u008e\7!\2\2\u008e\u008f\7\3\2\2\u008f\u0090\7\34\2\2\u0090"+
		"\33\3\2\2\2\u0091\u0092\7\35\2\2\u0092\u0094\7\60\2\2\u0093\u0095\5*\26"+
		"\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097"+
		"\7*\2\2\u0097\u0098\5(\25\2\u0098\u0099\7!\2\2\u0099\u009a\7\34\2\2\u009a"+
		"\35\3\2\2\2\u009b\u009f\5 \21\2\u009c\u009e\5\"\22\2\u009d\u009c\3\2\2"+
		"\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a3"+
		"\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a4\5$\23\2\u00a3\u00a2\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\37\3\2\2\2\u00a5\u00a6\7\5\2\2\u00a6\u00a7\5(\25"+
		"\2\u00a7\u00a8\7\34\2\2\u00a8\u00a9\5\4\3\2\u00a9\u00aa\7\6\2\2\u00aa"+
		"!\3\2\2\2\u00ab\u00ac\7\7\2\2\u00ac\u00ad\5(\25\2\u00ad\u00ae\7\34\2\2"+
		"\u00ae\u00af\5\4\3\2\u00af\u00b0\7\b\2\2\u00b0#\3\2\2\2\u00b1\u00b2\7"+
		"\t\2\2\u00b2\u00b3\5\4\3\2\u00b3\u00b4\7\n\2\2\u00b4%\3\2\2\2\u00b5\u00b6"+
		"\7\35\2\2\u00b6\u00b8\7\60\2\2\u00b7\u00b9\5.\30\2\u00b8\u00b7\3\2\2\2"+
		"\u00b8\u00b9\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\7!\2\2\u00bb\u00d5"+
		"\7\34\2\2\u00bc\u00bd\7\35\2\2\u00bd\u00be\7\r\2\2\u00be\u00bf\5(\25\2"+
		"\u00bf\u00c0\7!\2\2\u00c0\u00c1\7\34\2\2\u00c1\u00d5\3\2\2\2\u00c2\u00c3"+
		"\7\35\2\2\u00c3\u00c4\7\21\2\2\u00c4\u00c5\5(\25\2\u00c5\u00c6\7!\2\2"+
		"\u00c6\u00c7\7\34\2\2\u00c7\u00d5\3\2\2\2\u00c8\u00c9\7\35\2\2\u00c9\u00ca"+
		"\7\22\2\2\u00ca\u00cb\5(\25\2\u00cb\u00cc\7!\2\2\u00cc\u00cd\7\34\2\2"+
		"\u00cd\u00d5\3\2\2\2\u00ce\u00cf\7\35\2\2\u00cf\u00d0\7\16\2\2\u00d0\u00d1"+
		"\5(\25\2\u00d1\u00d2\7!\2\2\u00d2\u00d3\7\34\2\2\u00d3\u00d5\3\2\2\2\u00d4"+
		"\u00b5\3\2\2\2\u00d4\u00bc\3\2\2\2\u00d4\u00c2\3\2\2\2\u00d4\u00c8\3\2"+
		"\2\2\u00d4\u00ce\3\2\2\2\u00d5\'\3\2\2\2\u00d6\u00d7\b\25\1\2\u00d7\u00d8"+
		"\7\37\2\2\u00d8\u00f5\5(\25\25\u00d9\u00da\7\33\2\2\u00da\u00f5\5(\25"+
		"\24\u00db\u00f5\7/\2\2\u00dc\u00f5\7.\2\2\u00dd\u00f5\7\17\2\2\u00de\u00e0"+
		"\5&\24\2\u00df\u00e1\5*\26\2\u00e0\u00df\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1"+
		"\u00f5\3\2\2\2\u00e2\u00e4\5,\27\2\u00e3\u00e5\5*\26\2\u00e4\u00e3\3\2"+
		"\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00f5\3\2\2\2\u00e6\u00e8\7\60\2\2\u00e7"+
		"\u00e9\5*\26\2\u00e8\u00e7\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00f5\3\2"+
		"\2\2\u00ea\u00ec\7\61\2\2\u00eb\u00ed\5*\26\2\u00ec\u00eb\3\2\2\2\u00ec"+
		"\u00ed\3\2\2\2\u00ed\u00f5\3\2\2\2\u00ee\u00ef\7\'\2\2\u00ef\u00f0\5("+
		"\25\2\u00f0\u00f2\7(\2\2\u00f1\u00f3\5*\26\2\u00f2\u00f1\3\2\2\2\u00f2"+
		"\u00f3\3\2\2\2\u00f3\u00f5\3\2\2\2\u00f4\u00d6\3\2\2\2\u00f4\u00d9\3\2"+
		"\2\2\u00f4\u00db\3\2\2\2\u00f4\u00dc\3\2\2\2\u00f4\u00dd\3\2\2\2\u00f4"+
		"\u00de\3\2\2\2\u00f4\u00e2\3\2\2\2\u00f4\u00e6\3\2\2\2\u00f4\u00ea\3\2"+
		"\2\2\u00f4\u00ee\3\2\2\2\u00f5\u0116\3\2\2\2\u00f6\u00f7\f\23\2\2\u00f7"+
		"\u00f8\7\32\2\2\u00f8\u0115\5(\25\23\u00f9\u00fa\f\22\2\2\u00fa\u00fb"+
		"\t\2\2\2\u00fb\u0115\5(\25\23\u00fc\u00fd\f\21\2\2\u00fd\u00fe\t\3\2\2"+
		"\u00fe\u0115\5(\25\22\u00ff\u0100\f\20\2\2\u0100\u0101\t\4\2\2\u0101\u0115"+
		"\5(\25\21\u0102\u0103\f\17\2\2\u0103\u0104\t\5\2\2\u0104\u0115\5(\25\20"+
		"\u0105\u0106\f\16\2\2\u0106\u0107\7\25\2\2\u0107\u0115\5(\25\17\u0108"+
		"\u0109\f\r\2\2\u0109\u010a\7\24\2\2\u010a\u0115\5(\25\16\u010b\u010c\f"+
		"\f\2\2\u010c\u010d\7,\2\2\u010d\u010e\5(\25\2\u010e\u010f\7-\2\2\u010f"+
		"\u0110\5(\25\r\u0110\u0115\3\2\2\2\u0111\u0112\f\13\2\2\u0112\u0113\7"+
		"\23\2\2\u0113\u0115\5(\25\f\u0114\u00f6\3\2\2\2\u0114\u00f9\3\2\2\2\u0114"+
		"\u00fc\3\2\2\2\u0114\u00ff\3\2\2\2\u0114\u0102\3\2\2\2\u0114\u0105\3\2"+
		"\2\2\u0114\u0108\3\2\2\2\u0114\u010b\3\2\2\2\u0114\u0111\3\2\2\2\u0115"+
		"\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117)\3\2\2\2"+
		"\u0118\u0116\3\2\2\2\u0119\u011a\7%\2\2\u011a\u011b\5(\25\2\u011b\u011c"+
		"\7&\2\2\u011c\u011e\3\2\2\2\u011d\u0119\3\2\2\2\u011e\u011f\3\2\2\2\u011f"+
		"\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120+\3\2\2\2\u0121\u0123\7%\2\2\u0122"+
		"\u0124\5.\30\2\u0123\u0122\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\3\2"+
		"\2\2\u0125\u0126\7&\2\2\u0126-\3\2\2\2\u0127\u012c\5(\25\2\u0128\u0129"+
		"\7+\2\2\u0129\u012b\5(\25\2\u012a\u0128\3\2\2\2\u012b\u012e\3\2\2\2\u012c"+
		"\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d/\3\2\2\2\u012e\u012c\3\2\2\2"+
		"\33\679@EOV]bu\u0094\u009f\u00a3\u00b8\u00d4\u00e0\u00e4\u00e8\u00ec\u00f2"+
		"\u00f4\u0114\u0116\u011f\u0123\u012c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}