#version 400
 
in vec2 pass_textureCoords;
in vec3 surfaceNormal;
in vec3 toLightVector;
in vec3 toCamera;
 
out vec4 out_Color;

uniform sampler2D textureSampler;
uniform vec3 lightColor;
uniform float shineDamper;
uniform float reflectivity;
 
void main(void) {
	vec3 unitNormal = normalize(surfaceNormal);
	vec3 unitLight = normalize(toLightVector);
	vec3 unitCamera = normalize(toCamera);
	vec3 lightDirection = -unitLight;
	
	float nDot1 = dot(unitNormal, unitLight);
	float brightness = max(nDot1, 0.2);
	vec3 diffuse = brightness * lightColor;
 	
 	vec3 reflectedLightDirection = reflect(lightDirection, unitNormal);
 	
 	float specularFactor = dot(reflectedLightDirection, unitCamera);
 	specularFactor = max(specularFactor, 0.0);
 	float dampedFactor = pow(specularFactor, shineDamper);
 	vec3 finalSpecular = dampedFactor * lightColor * reflectivity;

	vec4 textureColor = texture(textureSampler, pass_textureCoords);
	if(textureColor.a < 0.5) {
		discard;
	}
 	
    out_Color = vec4(diffuse, 1.0) * (textureColor + vec4(finalSpecular, 1.0));
    
}