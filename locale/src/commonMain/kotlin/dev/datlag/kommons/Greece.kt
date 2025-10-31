package dev.datlag.kommons


data object Greece : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("GR")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("GRC")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(300)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(30)
    override val continent: Continent = Continent.Europe
}