package dev.datlag.kommons


data object CaboVerde : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("CV")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("CPV")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(132)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(238)
}