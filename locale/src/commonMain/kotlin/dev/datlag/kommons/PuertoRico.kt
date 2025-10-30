package dev.datlag.kommons


data object PuertoRico : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("PR")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("PRI")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(630)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(1787, 1939)
}