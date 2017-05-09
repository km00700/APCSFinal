package com.millstech.models;

public class RawModel {
	private int vaoID;
	private int vertexCount;
	
	public RawModel(int id, int numVertices) {
		vaoID = id;
		vertexCount = numVertices;
	}

	public int getVaoID() {
		return vaoID;
	}

	public int getVertexCount() {
		return vertexCount;
	}
	
}
