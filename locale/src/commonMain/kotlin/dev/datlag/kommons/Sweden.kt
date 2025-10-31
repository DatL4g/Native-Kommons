package dev.datlag.kommons


data object Sweden : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("SE")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("SWE")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(752)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(46)
    override val continent: Continent = Continent.Europe
}