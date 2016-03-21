package com.xjtu.lzc;

import java.io.IOException;
import java.util.Map;




import main.java.com.hankcs.lda.LdaUtil; 

import main.java.com.hankcs.lda.Corpus;
import main.java.com.hankcs.lda.LdaGibbsSampler;

public class LDA4MyData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Corpus corpus = Corpus.load("mydata/datasets");
		
		LdaGibbsSampler ldaGibbsSampler = new LdaGibbsSampler(corpus.getDocument(),corpus.getVocabularySize());
		
		ldaGibbsSampler.gibbs(10);
		
		double[][] phi = ldaGibbsSampler.getPhi(); 
		Map<String,Double>[] topicMap = LdaUtil.translate(phi,corpus.getVocabulary(),10);
		LdaUtil.explain(topicMap); 
		
	}

}
