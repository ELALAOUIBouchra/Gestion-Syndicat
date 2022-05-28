$('a').removeClass('active');
$('a:contains(Statistiques)').addClass('active');
$("#main-content").load("page/statistiques.html");

function show(page) {
	if (page == 'depenses') {
		$('a').removeClass('active');
		$('a:contains(Depense)').addClass('active');
		$("#main-content").load("page/Depense.html");

		event.preventDefault();
	}
	if (page == "statistiques") {
		$('a').removeClass('active');
		$('a:contains(Statistiques)').addClass('active');
		$("#main-content").load("page/statistiques.html");
		event.preventDefault();
	}
	if (page == "revenus") {
		$('a').removeClass('active');
		$('a:contains(Revenus)').addClass('active');
		$("#main-content").load("page/revenus.html");
		event.preventDefault();
	}
	if (page == "categories") {
		$('a').removeClass('active');
		$('a:contains(Categories)').addClass('active');
		$("#main-content").load("page/categories.html");
		event.preventDefault();
	}
	if (page == "immeubles") {
		$('a').removeClass('active');
		$('a:contains(Immeubles)').addClass('active');
		$("#main-content").load("page/immeuble.html");
		event.preventDefault();
	}
	if (page == "appartements") {
		$('a').removeClass('active');
		$('a:contains(Appartements)').addClass('active');
		$("#main-content").load("page/appartement.html");
		event.preventDefault();
	}
}
