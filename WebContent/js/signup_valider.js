/**
 * Fonctions utilisées pour les formulaires d'inscription et de mise à jour de profil
*/

var site_link="";

/**
 * Permet de valider les champs mot de passe
*/
function ValiderPassword (event) {
	var inputPassword = document.getElementById('inputPassword').value;
	var inputPassword2 = document.getElementById('inputPassword2').value;
	$("#helpPassword").remove();
	$("#helpPassword2").remove();
	if (inputPassword != inputPassword2) {
		$("#inputPassword2").closest('div').parent().addClass("error");
		$("#inputPassword2").closest('div').parent().removeClass("success");
		$("#inputPassword2").after("<span id='helpPassword' class='help-inline'><i class='icon-remove'></i></span>");
		return false;
	} else {
		$("#inputPassword").closest('div').parent().addClass("success");
		$("#inputPassword").closest('div').parent().removeClass("error");
		$("#inputPassword2").closest('div').parent().addClass("success");
		$("#inputPassword2").closest('div').parent().removeClass("error");
		$("#inputPassword").after("<span id='helpPassword' class='help-inline'><i class='icon-ok'></i></span>");
		$("#inputPassword2").after("<span id='helpPassword2' class='help-inline'><i class='icon-ok'></i></span>");
		return true;
	}
}

/**
 * Permet de valider le champ nom
*/
function ValiderNom (event) {
	var inputNom = document.getElementById('inputNom').value;
	$("#helpNom").remove();
	if (inputNom.length < 2) {
		$("#inputNom").closest('div').parent().addClass("error");
		$("#inputNom").closest('div').parent().removeClass("success");
		$("#inputNom").after("<span id='helpNom' class='help-inline'><i class='icon-remove'></i></span>");
		return false;
	} else {
		$("#inputNom").closest('div').parent().addClass("success");
		$("#inputNom").closest('div').parent().removeClass("error");
		$("#inputNom").after("<span id='helpNom' class='help-inline'><i class='icon-ok'></i></span>");
		return true;
	}
}

/**
 * Permet de valider le champ prénom
*/
function ValiderPrenom (event) {
	var inputPrenom = document.getElementById('inputPrenom').value;
	$("#helpPrenom").remove();
	if (inputPrenom.length < 2) {
		$("#inputPrenom").closest('div').parent().addClass("error");
		$("#inputPrenom").closest('div').parent().removeClass("success");
		$("#inputPrenom").after("<span id='helpPrenom' class='help-inline'><i class='icon-remove'></i></span>");
		return false;
	} else {
		$("#inputPrenom").closest('div').parent().addClass("success");
		$("#inputPrenom").closest('div').parent().removeClass("error");
		$("#inputPrenom").after("<span id='helpPrenom' class='help-inline'><i class='icon-ok'></i></span>");
		return true;
	}
}

/**
 * Permet de vérifier que le champs mail a bien une forme de mail
*/
function ValiderEmail(event) {
	var regex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	var inputEmail = document.getElementById('inputEmail').value;
	$("#helpEmail").remove();
	if (!regex.test(inputEmail)) {
		$("#inputEmail").closest('div').parent().addClass("error");
		$("#inputEmail").closest('div').parent().removeClass("success");
		$("#inputEmail").after("<span id='helpEmail' class='help-inline'><i class='icon-remove'></i></span>");
		return false;
	} else {
		$("#inputEmail").closest('div').parent().addClass("success");
		$("#inputEmail").closest('div').parent().removeClass("error");
		$("#inputEmail").after("<span id='helpEmail' class='help-inline'><i class='icon-ok'></i></span>");
		return true;
	}				
}

/**
 * Permet de vérifier que le mail n'existe pas déjà
*/
function CheckEmailUpdate(event){  
	
	var inputEmail = document.getElementById('inputEmail').value;
	var inputEmailInit = document.getElementById('initialMail').value;
	if( inputEmail == inputEmailInit )
		return true;
	else
		return CheckEmail();
}

/**
 * Permet de vérifier que le mail n'existe pas déjà
*/
function CheckEmail(event){  
	return true;	//tODO : change !
	var inputEmail = document.getElementById('inputEmail').value;
    var returnValue = null;
    $.ajaxSetup({async: false});   
	$.post(site_link+"/section_membres/php/signup_check.php", { Email: inputEmail},function(result){

	    $.ajaxSetup({async: true});
		if (result == 1) {  
			$("#helpEmail").remove();
			$("#inputEmail").closest('div').parent().addClass("error");
			$("#inputEmail").closest('div').parent().removeClass("success");
			$("#inputEmail").after("<span id='helpEmail' class='help-inline'><i class='icon-remove'></i> Impossible de s'inscrire avec cette adresse !</span>");
			returnValue = false;
		} else returnValue = true;
	});
	
    return returnValue;
}

/**
 * Permet de vérifier que tous les champs sont corrects lors d'une inscription
*/
function ValiderFormulaire(event) {
	if (ValiderNom() && ValiderPrenom() && ValiderEmail() && loginValidation() && CheckEmail()) {
		return true;
	} else {
		alert("Certains champs sont incorrects !");
		return false;
	}
}

/**
 * Permet de vérifier que tous les champs sont corrects lors d'un update
*/
function ValiderFormulaireUpdate(event) {
	if ( ValiderEmail() && CheckEmailUpdate() && loginValidation()) {
		return true;
	} else {
		alert("Certains champs sont incorrects !");
		return false;
	}
}

function loginValidation(){
	if(ValiderPassword() ){
	    //Récupération du mot de passe
	    var pass = document.getElementById('inputPassword').value;
	    //Remise a zéro du mot de passe
	    document.getElementById('inputPassword').value = "";
		document.getElementById('inputPassword2').value = "";
	    //Cryptage du mot de passe en MD5 à l'aide de la fonction MD5()
	    //présente dans le fichier md5.js

	    var buf = hex_md5(pass.toString());
	    //Ecriture du mot de passe dans le champ md5
	    document.getElementById('outputPassword').value = buf;
	    //Envoi du formulaire
	    return true;
	}
	else
		return false;
}

/**
 * Permet de coder le mot de passe et d'effacer les mots de passe dans les autres champs
*/
function codagePassword(){
	    //Récupération du mot de passe
	    var pass = document.getElementById('inputPassword').value;
	    //Remise a zéro du mot de passe
	    document.getElementById('inputPassword').value = "";
		document.getElementById('inputPassword2').value = "";
	    //Cryptage du mot de passe en MD5 à l'aide de la fonction MD5()
	    //présente dans le fichier md5.js

	    var buf = hex_md5(pass.toString());
	    //Ecriture du mot de passe dans le champ md5
	    document.getElementById('outputPassword').value = buf;
	    //Envoi du formulaire
	    return true;
}

function codagePasswordConnexion(){
	    //Récupération du mot de passe
	    var pass = document.getElementById('inputPassword').value;
	    //Remise a zéro du mot de passe
	    document.getElementById('inputPassword').value = "";
	    //Cryptage du mot de passe en MD5 à l'aide de la fonction MD5()
	    //présente dans le fichier md5.js

	    var buf = hex_md5(pass.toString());
	    //Ecriture du mot de passe dans le champ md5
	    document.getElementById('outputPassword').value = buf;
	    //Envoi du formulaire
	    return true;
}