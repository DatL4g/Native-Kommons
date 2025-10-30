package dev.datlag.kommons


data object AntiguaAndBarbuda : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("AG")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("ATG")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(28)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(1268)
}