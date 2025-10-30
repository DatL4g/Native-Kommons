package dev.datlag.kommons


data object Guadeloupe : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("GP")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("GLP")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(312)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(590)
}