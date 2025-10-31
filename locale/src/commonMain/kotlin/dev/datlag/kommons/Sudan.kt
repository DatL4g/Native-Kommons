package dev.datlag.kommons


data object Sudan : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("SD")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("SDN")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(729)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(249)
    override val continent: Continent = Continent.Africa
}