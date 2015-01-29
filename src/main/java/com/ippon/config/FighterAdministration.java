package com.ippon.config;

import static org.lightadmin.api.config.utils.FilterMetadataUtils.filter;
import static org.lightadmin.api.config.utils.ScopeMetadataUtils.all;
import static org.lightadmin.api.config.utils.Editors.textArea;
import static org.lightadmin.api.config.utils.EnumElement.element;

import org.lightadmin.api.config.AdministrationConfiguration;
import org.lightadmin.api.config.builder.EntityMetadataConfigurationUnitBuilder;
import org.lightadmin.api.config.builder.FieldSetConfigurationUnitBuilder;
import org.lightadmin.api.config.builder.FiltersConfigurationUnitBuilder;
import org.lightadmin.api.config.builder.PersistentFieldSetConfigurationUnitBuilder;
import org.lightadmin.api.config.builder.ScopesConfigurationUnitBuilder;
import org.lightadmin.api.config.builder.ScreenContextConfigurationUnitBuilder;
import org.lightadmin.api.config.unit.EntityMetadataConfigurationUnit;
import org.lightadmin.api.config.unit.FieldSetConfigurationUnit;
import org.lightadmin.api.config.unit.FiltersConfigurationUnit;
import org.lightadmin.api.config.unit.ScopesConfigurationUnit;
import org.lightadmin.api.config.unit.ScreenContextConfigurationUnit;

import com.ippon.model.Fighter;

public class FighterAdministration extends AdministrationConfiguration<Fighter> {

	private static final String FIGHTERS_ADMINISTRATION = "Zarządzaj zawodnikami";
	private static final String FIGHTERS = "Zawodnicy";
	private static final String FIGHTER = "Zawodnik";

	public EntityMetadataConfigurationUnit configuration(
			EntityMetadataConfigurationUnitBuilder configurationBuilder) {
		return configurationBuilder.singularName(FIGHTER).pluralName(FIGHTERS)
		// .repositoryEventListener(SimpleRepositoryEventListener.class)
				.field("district").enumeration(
                        element("1", "1"),
                        element("2", "2"),
                        element("3", "3"),
                        element("4", "4"),
                        element("poza Rybnikiem", "poza Rybnikiem"))
				.build();
	}

	public ScreenContextConfigurationUnit screenContext(
			ScreenContextConfigurationUnitBuilder screenContextBuilder) {
		return screenContextBuilder.screenName(FIGHTERS_ADMINISTRATION).build();
	}

	public FieldSetConfigurationUnit listView(
			final FieldSetConfigurationUnitBuilder fragmentBuilder) {
		return fragmentBuilder
				.field("id").caption("Lp.")
				// .field("avatar").caption("Avatar")
				.field("firstname").caption("Imię")
				.field("lastname").caption("Nazwisko")
				.field("dateOfBirth").caption("Data Urodzenia")
				.field("grade").caption("Stopień")
				.field("address").caption("Adres")
				.field("district").caption("Dzielnica")
				.build();
	}

	public FieldSetConfigurationUnit quickView(
			final FieldSetConfigurationUnitBuilder fragmentBuilder) {
		return fragmentBuilder
				.field("id")
				.caption("Lp.")
				// .field("avatar").caption("Avatar")
				.field("firstname").caption("Imię")
				.field("lastname").caption("Nazwisko")
				.field("dateOfBirth").caption("Data Urodzenia")
				.field("parentsName").caption("Rodzice")
				.field("parentsPhone").caption("Telefon rodziców")
				.field("grade").caption("Stopień")
				.field("emailAddress").caption("Email")
				.field("address").caption("Adres")
				.field("district").caption("Dzielnica")
				.field("fights").caption("Walki")
				.build();
	}

	public FieldSetConfigurationUnit showView(
			final FieldSetConfigurationUnitBuilder fragmentBuilder) {
		return fragmentBuilder
				.field("id").caption("Lp.")
				// .field("avatar").caption("Avatar")
				.field("firstname").caption("Imię")
				.field("lastname").caption("Nazwisko")
				.field("dateOfBirth").caption("Data Urodzenia")
				.field("parentsName").caption("Rodzice")
				.field("parentsPhone").caption("Telefon rodziców")
				.field("grade").caption("Stopień")
				.field("emailAddress").caption("Email")
				.field("address").caption("Adres")
				.field("district").caption("Dzielnica")
				.field("fights").caption("Walki")
				.build();
	}

	public FieldSetConfigurationUnit formView(
			final PersistentFieldSetConfigurationUnitBuilder fragmentBuilder) {
		return fragmentBuilder
				// .field("avatar").caption("Avatar")
				.field("firstname").caption("Imię")
				.field("lastname").caption("Nazwisko")
				.field("dateOfBirth").caption("Data Urodzenia")
				.field("parentsName").caption("Rodzice")
				.field("parentsPhone").caption("Telefon rodziców")
				.field("grade").caption("Stopień")
				.field("emailAddress").caption("Email")
				.field("address").caption("Adres")
				.field("district").caption("Dzielnica")
				.field("fights").caption("Walki").editor(textArea())
				.build();
	}

	public ScopesConfigurationUnit scopes(
			final ScopesConfigurationUnitBuilder scopeBuilder) {
		return scopeBuilder.scope("All", all()).defaultScope()
				// .scope("Buyers",
				// ScopeMetadataUtils.filter(DomainTypePredicates.alwaysTrue()))
//				.scope("Śródmieście", specification(districtEqualsCentrum()))
				.build();
	}

	public FiltersConfigurationUnit filters(
			final FiltersConfigurationUnitBuilder filterBuilder) {
		return filterBuilder
				.filters(

						// .field("avatar").caption("Avatar")
						filter().field("firstname").caption("Imię").build(),
						filter().field("lastname").caption("Nazwisko").build(),
						filter().field("dateOfBirth").caption("Data Urodzenia").build(),
						filter().field("grade").caption("Stopień").build(),
						filter().field("emailAddress").caption("Email").build(),
						filter().field("address").caption("Adres").build(),
						filter().field("district").caption("Dzielnica").build()

				).build();
	}

//	private DomainTypeSpecification<Fighter> districtEqualsCentrum() {
//		return new DomainTypeSpecification<Fighter>() {
//			@Override
//			public Predicate toPredicate(final Root<Fighter> root,
//					final CriteriaQuery<?> query, final CriteriaBuilder cb) {
//				return cb.equal(root.get("district"), "Śródmieście");
//			}
//		};
//	}

}
